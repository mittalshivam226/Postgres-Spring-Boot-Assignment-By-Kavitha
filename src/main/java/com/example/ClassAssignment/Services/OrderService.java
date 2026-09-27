package com.example.ClassAssignment.Services;


import com.example.ClassAssignment.Entity.OrderEntity;
import com.example.ClassAssignment.Repository.OrderRepository;
import com.example.ClassAssignment.dto.CustomerDTO;
import com.example.ClassAssignment.dto.CustomerOrderJoinedDTO;
import com.example.ClassAssignment.dto.OrderDTO;
import com.example.ClassAssignment.interfaceProjections.AverageOrderAmount;
import com.example.ClassAssignment.interfaceProjections.CountOrders;
import com.example.ClassAssignment.interfaceProjections.CustomerOrderSummary;
import com.example.ClassAssignment.interfaceProjections.SumOfAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> getCustomerOrders(int customerId) {
        List<OrderEntity> orderList = orderRepository.findByCustomerId(customerId);
        List<OrderDTO> customerDto = new ArrayList<>();

        for (OrderEntity o : orderList) {

            customerDto.add(OrderDTO.builder()
                    .orderId(o.getOrderId())
                    .orderDate(o.getOrderDate())
                    .status(o.getStatus())
                    .totalAmount(o.getTotalAmount())
                    .build());
        }
        return customerDto;
    }


    public List<CustomerOrderJoinedDTO> findOrders(){
        List<OrderEntity> orderlist = orderRepository.findOrders();
        List<CustomerOrderJoinedDTO> joinedDTO = new ArrayList<>();

        for(OrderEntity o : orderlist){
            joinedDTO.add(CustomerOrderJoinedDTO.builder()
                    .customerId(o.getCustomer().getCustomerId())
                    .city(o.getCustomer().getCity())
                    .referredBy(o.getCustomer().getReferredBy().getCustomerId())
                    .name(o.getCustomer().getName())
                    .orderId(o.getOrderId())
                    .totalAmount(o.getTotalAmount())
                    .status(o.getStatus())
                    .orderDate(o.getOrderDate())
                    .build());
        }
        return joinedDTO;
    }


    public List<CountOrders> countOrdersByCustomer() {
        return orderRepository.countOrdersByCustomer();
    }

    public List<CountOrders> countOrdersByCustomerUsingNativeQuery() {
        return orderRepository.countOrdersByCustomerUsingNativeQuery();
    }

    public List<SumOfAmount> totalAmountByCustomer() {
        return orderRepository.totalAmountByCustomer();
    }

    public List<CustomerOrderSummary> getCustomerOrderSummary() {
        return orderRepository.getCustomerOrderSummary();
    }

    public List<AverageOrderAmount> getAverageOrderAmount() {
        return orderRepository.getAverageOrderAmount();
    }
}
