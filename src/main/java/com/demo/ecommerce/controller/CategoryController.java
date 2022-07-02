package com.demo.ecommerce.controller;

import com.demo.ecommerce.common.ServiceResult;
import com.demo.ecommerce.dto.CategoryDto;
import com.demo.ecommerce.service.concrete.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDto> add(@RequestBody @Valid CategoryDto categoryDto) {
        ServiceResult<CategoryDto> serviceResult = categoryService.add(categoryDto);
        if (serviceResult.isSuccess()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getbyname")
    public ResponseEntity<ServiceResult<List<CategoryDto>>> getByCategoryName(@RequestParam(value = "name") String name) {
        if (categoryService.findByCategoryName(name).isSuccess()) {
            return new ResponseEntity<>(categoryService.findByCategoryName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(categoryService.findByCategoryName(name),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<ServiceResult<List<CategoryDto>>> getAll() {
        if (categoryService.getAll().isSuccess()) {
            return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
