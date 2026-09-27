package com.example.ClassAssignment.Controllers;


import com.example.ClassAssignment.Services.OrderService;
import com.example.ClassAssignment.dto.CustomerOrderJoinedDTO;
import com.example.ClassAssignment.dto.OrderDTO;
import com.example.ClassAssignment.interfaceProjections.AverageOrderAmount;
import com.example.ClassAssignment.interfaceProjections.CountOrders;
import com.example.ClassAssignment.interfaceProjections.CustomerOrderSummary;
import com.example.ClassAssignment.interfaceProjections.SumOfAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getCustomer/{customerId}")
    public List<OrderDTO> getCustomer(@PathVariable int customerId) {
        return orderService.getCustomerOrders(customerId);
    }

    @GetMapping("/findOrders")
    public List<CustomerOrderJoinedDTO> findOrders(){
        return orderService.findOrders();
    }

    @GetMapping("/countOrdersByCustomer")
    public List<CountOrders> countOrdersByCustomer() {
        return orderService.countOrdersByCustomer();
    }

    @GetMapping("/countOrdersByCustomerNative")
    public List<CountOrders> countOrdersByCustomerUsingNativeQuery() {
        return orderService.countOrdersByCustomerUsingNativeQuery();
    }

    @GetMapping("/totalAmountByCustomer")
    public List<SumOfAmount> totalAmountByCustomer() {
        return orderService.totalAmountByCustomer();
    }

    @GetMapping("/customerOrderSummary")
    public List<CustomerOrderSummary> getCustomerOrderSummary() {
        return orderService.getCustomerOrderSummary();
    }

    @GetMapping("/averageOrderAmount")
    public List<AverageOrderAmount> getAverageOrderAmount() {
        return orderService.getAverageOrderAmount();
    }
}
