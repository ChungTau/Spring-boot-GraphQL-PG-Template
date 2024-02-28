package com.chungtau.springboottemplate.entity.order;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.orderDetail.OrderDetail;
import com.chungtau.springboottemplate.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.CascadeType;
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
@EqualsAndHashCode(callSuper = true) 
@Entity
@Table(name = "orders")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order extends BaseEntity {
    private static final long serialVersionUID = 517472470L;

    @ManyToOne
    private User user;

    private String orderDate;

    private double totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}