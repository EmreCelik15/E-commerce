package com.demo.ecommerce.service.concrete;

import com.demo.ecommerce.common.ServiceResult;
import com.demo.ecommerce.dto.CategoryDto;
import com.demo.ecommerce.dto.CategoryDtoConverter;
import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.repository.CategoryRepository;
import org.hibernate.service.NullServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public ServiceResult<CategoryDto> add(CategoryDto categoryDto) {
        ServiceResult<CategoryDto> serviceResult = new ServiceResult<>();
        Category category = categoryRepository.save(categoryDtoConverter.toEntity(categoryDto));
        serviceResult.setData(categoryDtoConverter.convertDto(category));
        serviceResult.setMessage("Added");
        return serviceResult;
    }

    public ServiceResult<List<CategoryDto>> findByCategoryName(String name) {
        ServiceResult<List<CategoryDto>> serviceResult = new ServiceResult<>();
        try {
            if (name.length() > 0) {
                List<Category> categories = categoryRepository.getCategoriesByCategoryName(name).get();
                if (categories != null)
                    serviceResult.setData(categoryDtoConverter.convertToCategoryDtoList(categoryRepository.getCategoriesByCategoryName(name).get()));
                serviceResult.setMessage("Listed.");
                return serviceResult;
            } else {
                serviceResult.setMessage("Name length must be longer than 0");
                serviceResult.setSuccess(false);
                return serviceResult;
            }
        } catch (NullPointerException nullPointerException) {
            serviceResult.setMessage(String.valueOf(nullPointerException));
            serviceResult.setSuccess(false);
            return serviceResult;
        }
    }

    public ServiceResult<List<CategoryDto>> getAll() {
        ServiceResult<List<CategoryDto>> serviceResult = new ServiceResult<>();
        try {
            List<Category> categoryDtos = categoryRepository.findAll();
            if (categoryDtos!=null){
                serviceResult.setData(categoryDtoConverter.convertToCategoryDtoList(categoryDtos));
                serviceResult.setMessage("Categories listed");
                return serviceResult;
            }
            else{
                serviceResult.setMessage("Categories can not be listed!");
                serviceResult.setSuccess(false);
                return serviceResult;
            }
        }
        catch (NullPointerException nullPointerException){
            serviceResult.setMessage(String.valueOf(nullPointerException));
            serviceResult.setSuccess(false);
            return serviceResult;
        }
    }
}
