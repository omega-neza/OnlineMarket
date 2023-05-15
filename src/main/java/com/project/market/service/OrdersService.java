package com.project.market.service;

import com.project.market.dto.OrdersDto;
import com.project.market.model.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    Optional<OrdersDto> calculateOrder(Long productId);
    Orders placeOrder(OrdersDto ordersDto);
    Optional<Orders> getOrderById(Long orderId);

    List<Orders> getAllOrders();

    void deleteOrderById(Long id);
}
