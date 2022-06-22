package com.demo.ecommerce.service.concrete;

import com.demo.ecommerce.common.ServiceResult;
import com.demo.ecommerce.dto.BrandDto;
import com.demo.ecommerce.dto.BrandDtoConverter;
import com.demo.ecommerce.model.Brand;
import com.demo.ecommerce.repository.BrandRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRespository brandRespository;
    private final BrandDtoConverter brandDtoConverter;

    public BrandService(BrandRespository brandRespository, BrandDtoConverter brandDtoConverter) {
        this.brandRespository = brandRespository;
        this.brandDtoConverter = brandDtoConverter;
    }

    public ServiceResult<BrandDto> findBrandById(Long id) {
        ServiceResult<BrandDto> serviceResult = new ServiceResult<>();
        Optional<Brand> optionalBrand = brandRespository.findById(id);
        if (optionalBrand.isPresent()) {
            serviceResult.setData(brandDtoConverter.convertDto(optionalBrand.get()));
            serviceResult.setMessage("Category was bring");
            return serviceResult;
        }
        serviceResult.setSuccess(false);
        serviceResult.setMessage("Brand was not found ID:" + id);
        return serviceResult;
    }

    public ServiceResult<BrandDto> add(BrandDto brandDto) {
        ServiceResult<BrandDto> serviceResult = new ServiceResult<>();

        if (brandDto.getBrandName().equals(null)) {
            serviceResult.setMessage("Brand name can not be null");
            serviceResult.setSuccess(false);
            return serviceResult;
        } else {
            Brand brand = brandRespository.save(brandDtoConverter.toEntity(brandDto));
            serviceResult.setData(brandDtoConverter.convertDto(brand));
            serviceResult.setMessage("Brand Added");
            return serviceResult;
        }
    }

    public ServiceResult<List<BrandDto>> findAll() {
        ServiceResult<List<BrandDto>> serviceResult = new ServiceResult<>();
        if (serviceResult.isSuccess()) {
            List<Brand> brand = brandRespository.findAll();
            serviceResult.setData(brandDtoConverter.convertToBrandDToList(brand));
            serviceResult.setMessage("Brands is listed.");
            return serviceResult;
        } else {
            serviceResult.setMessage("Brand can not list.");
            return serviceResult;
        }

    }
}
