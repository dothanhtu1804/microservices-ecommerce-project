package com.example.stock_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceAPI {

    COUNTRY("Country Service"), WAREHOUSE("Warehouse Service");
    private final String value;
}
