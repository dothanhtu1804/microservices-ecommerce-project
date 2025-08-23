package com.example.stock_service.service.impl;

import com.example.stock_service.dto.WarehouseDTO;
import com.example.stock_service.entity.Country;
import com.example.stock_service.entity.Warehouse;
import com.example.stock_service.enums.ServiceAPI;
import com.example.stock_service.exception.wrapper.CommonException;
import com.example.stock_service.repository.WarehouseRepository;
import com.example.stock_service.service.CountryService;
import com.example.stock_service.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private CountryService countryService;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse getWarehouseById(long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> {
            log.error("{} - Get Warehouse By Id - error with id {}", ServiceAPI.WAREHOUSE.getValue(), id);
            return new CommonException("Error warehouse not found with id: " + id);
        });
    }

    public Warehouse getWarehouseByCodeAndName(String code, String name) {
        return warehouseRepository.findByWarehouseCodeAndWarehouseName(code, name);
    }

    @Override
    @Transactional
    public Warehouse saveWarehouse(WarehouseDTO warehouseDTO) {
        Country existingCountry = countryService.getCountryById(warehouseDTO.getCountryId());
        if (existingCountry == null) {
            log.error("{} - Create Warehouse - There is no country with code {} exist", ServiceAPI.WAREHOUSE.getValue(), warehouseDTO.getCountryId());
            throw new CommonException("There is no country with code " + warehouseDTO.getCountryId() + " exist.");
        }
        Warehouse existingWarehouse = getWarehouseByCodeAndName(warehouseDTO.getWarehouseCode(), warehouseDTO.getWarehouseName());
        if (existingWarehouse != null) {
            log.error("{} - Create Warehouse - code {} or name {} exist", ServiceAPI.WAREHOUSE.getValue(), warehouseDTO.getWarehouseCode(), warehouseDTO.getWarehouseName());
            throw new CommonException("The code " + warehouseDTO.getWarehouseCode() + " or name " + warehouseDTO.getWarehouseName() +" exist.");
        }
        Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);
        return warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public Warehouse updateWarehouse(WarehouseDTO warehouseDTO) {
        try {
            Warehouse existingWarehouse = getWarehouseById(warehouseDTO.getId());
            Warehouse warehouse = modelMapper.map(warehouseDTO, Warehouse.class);
            warehouse.setId(existingWarehouse.getId());
            return warehouseRepository.save(warehouse);
        } catch (Exception e) {
            log.error("{} - Update Warehouse - error with id {} with error {}", ServiceAPI.WAREHOUSE.getValue(), warehouseDTO.getId(), e.getMessage());
            throw new CommonException("Error update warehouse with id " + warehouseDTO.getId(), e);
        }
    }
}
