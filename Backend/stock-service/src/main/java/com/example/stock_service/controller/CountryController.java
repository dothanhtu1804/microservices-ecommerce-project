package com.example.stock_service.controller;

import com.example.stock_service.dto.CountryDTO;
import com.example.stock_service.entity.Country;
import com.example.stock_service.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
@Slf4j
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Country> createCategory(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.createCategory(request));
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public ResponseEntity<Country> updateCategory(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.updateCategory(request));
    }
}
