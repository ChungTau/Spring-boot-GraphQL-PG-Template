package com.chungtau.springboottemplate.entity.product;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.cart.Cart;
import com.chungtau.springboottemplate.entity.category.Category;
import com.chungtau.springboottemplate.entity.orderDetail.OrderDetail;
import com.chungtau.springboottemplate.entity.review.Review;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@EqualsAndHashCode(callSuper = true) 
@Entity
@Table(name = "products")
@QueryEntity
public class Product extends BaseEntity {
    private static final long serialVersionUID = -1399281896L;

    private String name;

    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    private Cart cart;
}