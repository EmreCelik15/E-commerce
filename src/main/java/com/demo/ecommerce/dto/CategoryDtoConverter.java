package com.demo.ecommerce.dto;


import com.demo.ecommerce.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDtoConverter {
    public CategoryDto convertDto(Category from){
        return new CategoryDto(from.getId(),from.getCategoryName());
    }
    public Category toEntity(CategoryDto from){
        return new Category(from.getId(),from.getCategoryName());
    }
    public List<CategoryDto> convertToCategoryDtoList(List<Category> categories){
        List<CategoryDto> categoryDtos=new ArrayList<>();
        categories.forEach(category -> categoryDtos.add(convertDto(category)));
        return categoryDtos;
    }
    public List<Category> convertToCategoryEntityList(List<CategoryDto> categoryDtos){
        List<Category> categories=new ArrayList<>();
        categoryDtos.forEach(categoryDto -> categories.add(toEntity(categoryDto)));
        return categories;
    }
}
