package com.chungtau.springboottemplate.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.chungtau.springboottemplate.entity.orderDetail.OrderDetail;

@GraphQlRepository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, String>, QuerydslPredicateExecutor<OrderDetail> {
    
}