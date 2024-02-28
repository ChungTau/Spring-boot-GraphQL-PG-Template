package com.chungtau.springboottemplate.entity.user;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chungtau.springboottemplate.entity.BaseEntity;
import com.chungtau.springboottemplate.entity.cart.Cart;
import com.chungtau.springboottemplate.entity.event.Event;
import com.chungtau.springboottemplate.entity.order.Order;
import com.chungtau.springboottemplate.entity.review.Review;
import com.chungtau.springboottemplate.entity.role.Role;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "users")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity {
    private static final long serialVersionUID = -28447114L;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany
    private List<Event> events;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Event> hostedEvents;

    @OneToOne
    private Cart cart;
}
