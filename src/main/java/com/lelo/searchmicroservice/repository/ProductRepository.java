package com.lelo.searchmicroservice.repository;

import com.lelo.searchmicroservice.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    public int countByName(String name);
}
