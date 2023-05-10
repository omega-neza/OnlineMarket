package com.project.market.dto;

import com.project.market.model.Products;
import jdk.jfr.ContentType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductsDto {
    private long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Price per unit cannot be null")
    private BigDecimal pricePerUnit;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @NotNull(message = "Picture cannot be null")
    @Size(max = 5000000, message = "Picture size must be less than 5MB")

    public ProductsDto() {
    }

    public ProductsDto(long id, String name, String description, BigDecimal pricePerUnit, String category, MultipartFile pic) {
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

    @NotBlank(message = "Picture must be provided")
    private MultipartFile pic;

    public MultipartFile getPic() {
        return pic;
    }


    public boolean isPicValid() {
        String contentType = pic.getContentType();
        return contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"));
    }

    public void setPic(MultipartFile pic) {
        this.pic = pic;
    }
}

