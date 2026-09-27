package com.example.ClassAssignment.Entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Customers")
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    private String name;

    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referred_by")
    private CustomerEntity referredBy;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
