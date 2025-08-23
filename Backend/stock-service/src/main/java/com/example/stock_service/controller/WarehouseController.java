package com.example.stock_service.controller;

import com.example.stock_service.dto.WarehouseDTO;
import com.example.stock_service.entity.Warehouse;
import com.example.stock_service.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = "/warehouses")
    public ResponseEntity<List<Warehouse>> getWarehouses() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }

    @GetMapping(value = "/warehouse/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }

    @PostMapping(value = "/warehouse")
    public ResponseEntity<Warehouse> insertWarehouse(@RequestBody WarehouseDTO request) {
        return ResponseEntity.ok(warehouseService.saveWarehouse(request));
    }

    @PutMapping(value = "/warehouse")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody WarehouseDTO request) {
        return ResponseEntity.ok(warehouseService.updateWarehouse(request));
    }
}
