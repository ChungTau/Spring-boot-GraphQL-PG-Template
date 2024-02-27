package com.chungtau.springboottemplate.model.user;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.chungtau.springboottemplate.model.cart.Cart;
import com.chungtau.springboottemplate.model.event.Event;
import com.chungtau.springboottemplate.model.order.Order;
import com.chungtau.springboottemplate.model.review.Review;
import com.chungtau.springboottemplate.model.role.Role;
import com.querydsl.core.annotations.QueryEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@QueryEntity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
    private static final long serialVersionUID = -28447114L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

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
