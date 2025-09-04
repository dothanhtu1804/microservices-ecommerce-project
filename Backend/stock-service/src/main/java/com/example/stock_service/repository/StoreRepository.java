package com.example.stock_service.repository;

import com.example.stock_service.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByStoreCodeAndStoreName(String code, String name);
}
