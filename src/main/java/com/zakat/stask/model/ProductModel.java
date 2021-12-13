package com.zakat.stask.model;

import com.zakat.stask.entity.CurrencyLanguageMap;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class ProductModel {

    private Long id;
     @NotBlank(message = "Field must be filled")
    private String name;

    private String description;
    @DecimalMin(value = "0.01", message = "must be greater than 0")
    private double price;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-MM-DD")
    private String dateOfCreation;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-MM-DD")
    private String dateOfModification;

    private String language;

    public ProductModel() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", dateOfModification='" + dateOfModification + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
