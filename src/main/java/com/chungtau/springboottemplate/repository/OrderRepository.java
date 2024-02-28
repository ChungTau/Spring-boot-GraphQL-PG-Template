package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.entity.order.Order;

@GraphQlRepository
public interface OrderRepository extends CrudRepository<Order, String>, QuerydslPredicateExecutor<Order> {
    
}
