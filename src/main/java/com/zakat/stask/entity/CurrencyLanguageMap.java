package com.zakat.stask.entity;

import javax.persistence.*;

@Entity
@Table(name = "languagemap")
public class CurrencyLanguageMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "languages")
    private String language;

    public CurrencyLanguageMap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
