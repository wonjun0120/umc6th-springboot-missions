package com.umc.mission7.service.storeService;

import com.umc.mission7.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}