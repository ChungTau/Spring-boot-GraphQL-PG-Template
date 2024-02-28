package com.chungtau.springboottemplate.entity.orderDetail;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.order.Order;
import com.chungtau.springboottemplate.entity.product.Product;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true) 
@Table(name = "order_details")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderDetail extends BaseEntity {
    private static final long serialVersionUID = -2121062600L;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;

    private double price;
}