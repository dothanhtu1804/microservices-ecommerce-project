package com.example.stock_service.service;

import com.example.stock_service.dto.CountryDTO;
import com.example.stock_service.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country getCountryById(long id);

    Country saveCountry(CountryDTO country);

    Country updateCountry(CountryDTO country);
}
