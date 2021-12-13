package com.zakat.stask.repository;

import com.zakat.stask.entity.CurrencyLanguageMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<CurrencyLanguageMap, Long> {

    public CurrencyLanguageMap findByLanguage(String language);
}
