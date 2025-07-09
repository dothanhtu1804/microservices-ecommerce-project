package com.example.stock_service.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CountryDTO {
    private Long id;

    private String countryCode;

    private String countryName;

    private String defaultLanguage;

    private String currencyCode;

    private String createdBy;

    private Timestamp createdAt;

    private String updatedBy;
}
