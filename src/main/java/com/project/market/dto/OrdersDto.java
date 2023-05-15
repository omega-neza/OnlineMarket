package com.project.market.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrdersDto {
    private Long productId;
    private BigDecimal totalPrice;
    private CharSequence deliveryDate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CharSequence getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(CharSequence deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
