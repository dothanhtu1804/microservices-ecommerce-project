package com.example.stock_service.controller;

import com.example.stock_service.dto.WarehouseDTO;
import com.example.stock_service.entity.Warehouse;
import com.example.stock_service.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping(value = "/warehouses", method = RequestMethod.GET)
    public ResponseEntity<List<Warehouse>> getCountries() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }

    @RequestMapping(value = "/warehouse/{id}", method = RequestMethod.GET)
    public ResponseEntity<Warehouse> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }

    @RequestMapping(value = "/warehouse", method = RequestMethod.POST)
    public ResponseEntity<Warehouse> createCountry(@RequestBody WarehouseDTO request) {
        return ResponseEntity.ok(warehouseService.saveWarehouse(request));
    }

    @RequestMapping(value = "/warehouse", method = RequestMethod.PUT)
    public ResponseEntity<Warehouse> updateCountry(@RequestBody WarehouseDTO request) {
        return ResponseEntity.ok(warehouseService.updateWarehouse(request));
    }
}
