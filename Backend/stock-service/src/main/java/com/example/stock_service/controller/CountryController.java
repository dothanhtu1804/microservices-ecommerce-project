package com.example.stock_service.controller;

import com.example.stock_service.dto.CountryDTO;
import com.example.stock_service.entity.Country;
import com.example.stock_service.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping(value = "/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping(value = "/country")
    public ResponseEntity<Country> createCountry(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.saveCountry(request));
    }

    @PutMapping(value = "/country")
    public ResponseEntity<Country> updateCountry(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.updateCountry(request));
    }
}
