package com.trunghuynh.casestudy.controller;

import com.trunghuynh.casestudy.model.dto.response.PageResponse;
import com.trunghuynh.casestudy.model.dto.response.ProductResponseDto;
import com.trunghuynh.casestudy.model.entity.Product;
import com.trunghuynh.casestudy.model.mapper.ProductMapper;
import com.trunghuynh.casestudy.model.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getProductList() {
        List<Product> products = productService.findAllProduct();
        List<ProductResponseDto> productResponseDTOList = productMapper.convert(products);
        if (productResponseDTOList != null) {
            return new ResponseEntity<>(productResponseDTOList, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/allpage")
    public ResponseEntity<PageResponse<ProductResponseDto>> getAllProduct(@PageableDefault(value = 20, sort = "id") Pageable pageable,
                                                                          @RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "20") int size) {
        pageable = PageRequest.of(page, size, pageable.getSort());
        Page<Product> productPage = productService.findAllPage(pageable);
        Page<ProductResponseDto> productResponseDtoPage  = productPage.map(productMapper::convert);
        if (!productResponseDtoPage.isEmpty()) {
            int totalPages = productResponseDtoPage.getTotalPages();
            PageResponse<ProductResponseDto> pageResponse = new PageResponse<>(productResponseDtoPage, totalPages);
            return new ResponseEntity<>(pageResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductDetail(@PathVariable Long id){
        Product product = productService.findById(id).orElse(null);
        ProductResponseDto productResponseDTO = productMapper.convert(product);
        if(productResponseDTO != null){
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        } else return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
