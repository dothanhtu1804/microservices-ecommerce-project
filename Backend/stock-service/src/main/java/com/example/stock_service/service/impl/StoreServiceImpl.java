package com.example.stock_service.service.impl;

import com.example.stock_service.dto.StoreDTO;
import com.example.stock_service.entity.Country;
import com.example.stock_service.entity.Store;
import com.example.stock_service.enums.ServiceAPI;
import com.example.stock_service.exception.wrapper.CommonException;
import com.example.stock_service.repository.StoreRepository;
import com.example.stock_service.service.CountryService;
import com.example.stock_service.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    ModelMapper modelMapper = new ModelMapper();

    private final StoreRepository storeRepository;

    private final CountryService countryService;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
        this.countryService = new CountryServiceImpl();
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(long id) {
        return storeRepository.findById(id).orElseThrow(() -> {
            log.error("{} - Get Store By Id - error with id {}", ServiceAPI.WAREHOUSE.getValue(), id);
            return new CommonException("Error store not found with id: " + id);
        });
    }

    public Store getStoreByStoreCodeAndStoreName(String code, String name) {
        return storeRepository.findByStoreCodeAndStoreName(code, name);
    }

    @Override
    @Transactional
    public Store saveStore(StoreDTO storeDTO) {
        Country existingCountry = countryService.getCountryById(storeDTO.getCountryId());
        if (existingCountry == null) {
            log.error("{} - Create Store - There is no country with code {} exist", ServiceAPI.STORE.getValue(), storeDTO.getCountryId());
            throw new CommonException("There is no country with code " + storeDTO.getCountryId() + " exist.");
        }
        Store existingWarehouse = getStoreByStoreCodeAndStoreName(storeDTO.getStoreCode(), storeDTO.getStoreName());
        if (existingWarehouse != null) {
            log.error("{} - Create Store - code {} or name {} exist", ServiceAPI.WAREHOUSE.getValue(), storeDTO.getStoreCode(), storeDTO.getStoreName());
            throw new CommonException("The code " + storeDTO.getStoreCode() + " or name " + storeDTO.getStoreName() +" exist.");
        }
        Store store = modelMapper.map(storeDTO, Store.class);
        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Store updateStore(StoreDTO storeDTO) {
        try {
            Store existingStore = getStoreById(storeDTO.getId());
            Store store = modelMapper.map(storeDTO, Store.class);
            store.setId(existingStore.getId());
            return storeRepository.save(store);
        } catch (Exception e) {
            log.error("{} - Update Store - error with id {} with error {}", ServiceAPI.WAREHOUSE.getValue(), storeDTO.getId(), e.getMessage());
            throw new CommonException("Error update store with id " + storeDTO.getId(), e);
        }
    }
}
