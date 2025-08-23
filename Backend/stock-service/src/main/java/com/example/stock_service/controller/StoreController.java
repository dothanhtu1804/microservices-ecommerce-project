package com.example.stock_service.controller;

import com.example.stock_service.dto.StoreDTO;
import com.example.stock_service.entity.Store;
import com.example.stock_service.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(value = "/stores")
    public ResponseEntity<List<Store>> stores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @GetMapping(value = "/store/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @PostMapping(value = "/store")
    public ResponseEntity<Store> createStore(@RequestBody StoreDTO request) {
        return ResponseEntity.ok(storeService.saveStore(request));
    }

    @PutMapping(value = "/store")
    public ResponseEntity<Store> updateStore(@RequestBody StoreDTO request) {
        return ResponseEntity.ok(storeService.updateStore(request));
    }
}
