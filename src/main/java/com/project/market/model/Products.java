package com.project.market.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;

import javax.persistence.*;
import java.math.BigDecimal;


@Builder

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private String category;
    @Lob
    private byte[] pic;

    public Products() {
    }

    public Products(long id, String name, String description, BigDecimal pricePerUnit, String category, byte[] pic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
        this.pic = pic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}


