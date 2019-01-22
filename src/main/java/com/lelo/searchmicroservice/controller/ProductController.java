package com.lelo.searchmicroservice.controller;

import com.lelo.searchmicroservice.dto.ProductDTO;
import com.lelo.searchmicroservice.model.Product;
import com.lelo.searchmicroservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product productCreated  = productService.add(product);
        return new ResponseEntity<String>(productCreated.getProductId(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public ProductDTO findOneProduct(@RequestParam String productId){
        Product product = productService.findOne(productId);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductDTO> findAllProduct(){
        Iterable<Product> productList = productService.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product _product : productList){
            ProductDTO _productDTO = new ProductDTO();
            BeanUtils.copyProperties(_product, _productDTO);
            productDTOList.add(_productDTO);
        }
        return productDTOList;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteProduct(@RequestParam String productId){
        Product product = productService.findOne(productId);
        productService.delete(productId);
        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product productCreated = productService.add(product);
        return new ResponseEntity<String>(productCreated.getProductId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Collection<Product> query(String queryText){
        return productService.query(queryText);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int testingShit(@RequestParam String name){
//        final String uri="http://172.16.20.92:8080/productMerchants/getByProductId/string";
//        RestTemplate restTemplate = new RestTemplate();
//        ProductMerchantDTO productMerchantDTORecieved = restTemplate.getForObject(uri, ProductMerchantDTO.class);
        return productService.countFunc(name);
    }
}
