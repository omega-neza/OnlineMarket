package com.project.market.controller;

import com.project.market.dto.OrdersDto;
import com.project.market.model.Orders;
import com.project.market.model.Products;
import com.project.market.repository.ProductServiceImpl;
import com.project.market.service.OrdersService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.project.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;

    @GetMapping("/buy")
    public String buyProduct(@RequestParam Long productId, Model model) {

        Products product = productService.getProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("deliveryDate", LocalDate.now().plusDays(10));
        model.addAttribute("ordersDto", new OrdersDto());
        return "Order";
    }
    @GetMapping("/AllOrders")
    public String getAllOrders(Model model){
        List<Orders> orders=ordersService.getAllOrders();
        model.addAttribute("orders",orders);
        return "AllOrders";
    }
    @PostMapping("/buy")
    public String placeOrder(@ModelAttribute("product") OrdersDto ordersDto) {
        Orders order = ordersService.placeOrder(ordersDto);
        return "redirect:/orders/" + order.getId();
    }

    @GetMapping ("/delete_order/{id}")
    public String deleteOrder(@PathVariable("id")Long id){
        ordersService.deleteOrderById(id);
        return "redirect:/AllOrders";
    }


    @GetMapping("/orders/{orderId}")
    public String getOrderDetails(@PathVariable("orderId") Long orderId, Model model) {
        Optional<Orders> orderOptional = ordersService.getOrderById(orderId);
        if (orderOptional.isPresent()) {
            model.addAttribute("order", orderOptional.get());
            return "Confirmation";
        } else {
            return "redirect:/Categories";
        }
    }




}
