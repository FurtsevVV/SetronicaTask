package com.zakat.stask.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    @NotBlank(message = "Field must be filled")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    @DecimalMin(value = "0.01", message = "must be greater than 0")
    private double price;
    @Column(name = "date_of_creation")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-MM-DD")
    private String dateOfCreation;
    @Column(name = "date_of_modification")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Use pattern YYYY-MM-DD")
    private String dateOfModification;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "language_id")
    private CurrencyLanguageMap languageMap;

    public Product() {
    }

    public CurrencyLanguageMap getLanguageMap() {
        return languageMap;
    }

    public void setLanguageMap(CurrencyLanguageMap languageMap) {
        this.languageMap = languageMap;
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
}
