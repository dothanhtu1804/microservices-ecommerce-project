package com.example.stock_service.repository;

import com.example.stock_service.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse findByWarehouseCodeAndWarehouseName(String code, String name);
}
