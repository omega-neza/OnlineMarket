package com.project.market.repository;

import com.project.market.dto.OrdersDto;
import com.project.market.model.Orders;
import com.project.market.model.Products;
import com.project.market.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Optional<OrdersDto> calculateOrder(Long productId) {
        Optional<Products> productOptional = productsRepository.findById(productId);
        if (productOptional.isPresent()) {
            Products product = productOptional.get();
            OrdersDto ordersDto = new OrdersDto();
            ordersDto.setProductId(productId);
            ordersDto.setTotalPrice(product.getPricePerUnit());

            return Optional.of(ordersDto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Orders placeOrder(OrdersDto ordersDto) {
        Optional<Products> productOptional = productsRepository.findById(ordersDto.getProductId());
        if (productOptional.isPresent()) {
            Products product = productOptional.get();

            // Validate deliveryDate input
            LocalDate deliveryDate;
            try {
                deliveryDate = LocalDate.parse(ordersDto.getDeliveryDate());
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid deliveryDate format. Expected format: yyyy-MM-dd");
            }

            Orders order = new Orders(product, ordersDto.getTotalPrice(), deliveryDate);
            order.setTotalPrice(ordersDto.getTotalPrice());
            order.setDeliveryDate(deliveryDate);
            return ordersRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

    @Override
    public Optional<Orders> getOrderById(Long orderId) {
        return ordersRepository.findById(orderId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public void deleteOrderById(Long id) {
        ordersRepository.deleteById(id);
    }
}
