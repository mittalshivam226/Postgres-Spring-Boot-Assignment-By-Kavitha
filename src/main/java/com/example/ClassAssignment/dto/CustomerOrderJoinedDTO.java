package com.example.ClassAssignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrderJoinedDTO {

    private int customerId;
    private String city;
    private int referredBy;
    private String name;

    private int orderId;
    private int totalAmount;
    private String status;
    private LocalDate orderDate;
}
