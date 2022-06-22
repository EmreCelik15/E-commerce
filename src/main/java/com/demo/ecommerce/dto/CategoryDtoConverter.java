package com.demo.ecommerce.dto;


import com.demo.ecommerce.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {
    public CategoryDto convertDto(Category from){
        return new CategoryDto(from.getId(),from.getCategoryName());
    }
    public Category toEntity(CategoryDto from){
        return new Category(from.getId(),from.getBrandName());
    }
}
