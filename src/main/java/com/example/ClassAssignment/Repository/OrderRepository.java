package com.example.ClassAssignment.Repository;


import com.example.ClassAssignment.Entity.OrderEntity;
import com.example.ClassAssignment.interfaceProjections.AverageOrderAmount;
import com.example.ClassAssignment.interfaceProjections.CountOrders;
import com.example.ClassAssignment.interfaceProjections.CustomerOrderSummary;
import com.example.ClassAssignment.interfaceProjections.SumOfAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {


    @Query("SELECT o FROM OrderEntity o WHERE o.customer.customerId = :customer_id")
    List<OrderEntity> findByCustomerId(@Param("customer_id") int customer_id);

    @Query("SELECT o FROM OrderEntity o INNER JOIN customer c ON o.customer.customerId=c.customerId")
    List<OrderEntity> findOrders();

    @Query("""
    SELECT o.customer.customerId AS customerId, COUNT(o) AS orderCount
    FROM OrderEntity o
    GROUP BY o.customer.customerId
    """)
    List<CountOrders> countOrdersByCustomer();

    @NativeQuery(value = "SELECT o.customer_id AS customerId, COUNT(*) AS orderCount FROM Orders o GROUP BY o.customer_id")
    List<CountOrders> countOrdersByCustomerUsingNativeQuery();

    @Query("""
    SELECT o.customer.customerId AS customerId, SUM(o.totalAmount) AS totalSum
    FROM OrderEntity o
    GROUP BY o.customer.customerId
    """)
    List<SumOfAmount> totalAmountByCustomer();

    @NativeQuery(value = "SELECT c.customer_id AS customerId, c.name AS customerName, SUM(o.total_amount) AS totalSum FROM Orders o INNER JOIN Customers c ON o.customer_id = c.customer_id GROUP BY c.customer_id, c.name")
    List<CustomerOrderSummary> getCustomerOrderSummary();


    @Query("SELECT o.customer.customerId AS customerId, AVG(o.totalAmount) AS aerageAmount FROM OrderEntity o GROUP BY o.customer.customerId")
    List<AverageOrderAmount> getAverageOrderAmount();


}
