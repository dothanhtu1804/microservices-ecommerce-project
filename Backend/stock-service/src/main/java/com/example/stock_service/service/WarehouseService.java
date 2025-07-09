package com.example.stock_service.service;

import com.example.stock_service.dto.WarehouseDTO;
import com.example.stock_service.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> getAllWarehouses();

    Warehouse getWarehouseById(long id);

    Warehouse saveWarehouse(WarehouseDTO warehouse);

    Warehouse updateWarehouse(WarehouseDTO warehouse);
}
