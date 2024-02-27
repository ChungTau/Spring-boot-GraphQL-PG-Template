package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.model.product.Product;

@GraphQlRepository
public interface ProductRepository extends CrudRepository<Product, String>, QuerydslPredicateExecutor<Product> {
    
}