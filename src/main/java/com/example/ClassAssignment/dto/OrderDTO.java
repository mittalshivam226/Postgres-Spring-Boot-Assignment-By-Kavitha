package com.example.ClassAssignment.dto;


import com.example.ClassAssignment.Entity.CustomerEntity;
import com.example.ClassAssignment.Entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int orderId;
    private int totalAmount;
    private String status;
    private LocalDate orderDate;
}
