package com.depromeet.team5.service;

import com.depromeet.team5.domain.Store;
import com.depromeet.team5.dto.StoreCardDto;
import com.depromeet.team5.dto.StoreDto;
import com.depromeet.team5.dto.StoreMyPageDto;
import com.depromeet.team5.dto.UpdateDto;

import java.util.List;

public interface StoreService {
    void saveStore(StoreDto storeDto, Long userId);
    List<StoreCardDto> getAll(Float latitude, Float longitude);
    List<StoreMyPageDto> getAllByUser(Long userId);
    Store getDetail(Long storeId);
    void updateStore(UpdateDto updateDto, Long storeId);
    void deleteStore(Long storeId);
}
