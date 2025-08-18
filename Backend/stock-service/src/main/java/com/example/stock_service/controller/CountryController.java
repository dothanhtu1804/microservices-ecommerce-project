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

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public ResponseEntity<Country> createCountry(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.saveCountry(request));
    }

    @RequestMapping(value = "/country", method = RequestMethod.PUT)
    public ResponseEntity<Country> updateCountry(@RequestBody CountryDTO request) {
        return ResponseEntity.ok(countryService.updateCountry(request));
    }
}
