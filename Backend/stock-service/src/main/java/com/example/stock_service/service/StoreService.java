package com.example.stock_service.service;

import com.example.stock_service.dto.StoreDTO;
import com.example.stock_service.entity.Store;

import java.util.List;

public interface StoreService {

    List<Store> getAllStores();

    Store getStoreById(long id);

    Store saveStore(StoreDTO storeDTO);

    Store updateStore(StoreDTO storeDTO);
}
