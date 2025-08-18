package com.example.stock_service.service.Impl;

import com.example.stock_service.dto.CountryDTO;
import com.example.stock_service.entity.Country;
import com.example.stock_service.exception.wrapper.StockException;
import com.example.stock_service.repository.CountryRepository;
import com.example.stock_service.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(long id) {
        return countryRepository.findById(id).orElseThrow(() -> {
            log.error("Stock Service - Get Country By Id - error with id {}", id);
            return new StockException("Error country not found with id: " + id);
        });
    }

    public Country getCountryByCodeAndName(String code, String name) {
        return countryRepository.findByCountryCodeAndCountryName(code, name);
    }

    public Country saveCountry(CountryDTO countryDTO) {
        Country existingCountry = getCountryByCodeAndName(countryDTO.getCountryCode(), countryDTO.getCountryName());
        if (existingCountry != null) {
            log.error("Stock Service - Create Country - code {} or name {} exist", countryDTO.getCountryCode(), countryDTO.getCountryName());
            throw new StockException("Stock Service - Create Country - code " + countryDTO.getCountryCode() + " or name " + countryDTO.getCountryName() +" exist.");
        }
        Country country = modelMapper.map(countryDTO, Country.class);
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public Country updateCountry(CountryDTO countryDTO) {
        try {
            Country existingCountry = getCountryById(countryDTO.getId());
            Country country = modelMapper.map(countryDTO, Country.class);
            country.setId(existingCountry.getId());
            return countryRepository.save(country);
        } catch (Exception e) {
            log.error("Stock Service - Update Country - error with id {} with error {}", countryDTO.getId(), e.getMessage());
            throw new StockException("Error update country with id " + countryDTO.getId(), e);
        }
    }
}

