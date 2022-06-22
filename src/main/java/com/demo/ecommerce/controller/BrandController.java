package com.demo.ecommerce.controller;


import com.demo.ecommerce.common.ServiceResult;
import com.demo.ecommerce.dto.BrandDto;
import com.demo.ecommerce.service.concrete.BrandService;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id){
        ServiceResult<BrandDto> serviceResult=brandService.findBrandById(id);
        if(serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(),HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<BrandDto> add(@RequestBody BrandDto brandDto){
        ServiceResult<BrandDto> serviceResult=brandService.add(brandDto);
        if(serviceResult.isSuccess()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<BrandDto>> getAll(){
        ServiceResult<List<BrandDto>> serviceResult=brandService.findAll();
        if(serviceResult.isSuccess()){
            return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
