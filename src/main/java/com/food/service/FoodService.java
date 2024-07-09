package com.food.service;

import com.food.dto.FoodDto;
import com.food.dto.LoginDto;
import com.food.entity.FoodEntity;
import com.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodDto addFood(FoodDto foodDto) {
        FoodEntity entity = dtoToEntity(foodDto);
        FoodEntity savedEntity = foodRepository.save(entity);
        FoodDto dto = entityToDto(savedEntity);
        return dto;

    }

    FoodEntity dtoToEntity(FoodDto foodDto){
        FoodEntity entity=new FoodEntity();
        entity.setName(foodDto.getName());
        entity.setUsername(foodDto.getUsername());
        entity.setPassword(foodDto.getPassword());
        entity.setEmail(foodDto.getEmail());
        return entity;
    }
    FoodDto entityToDto(FoodEntity entity){
        FoodDto dto=new FoodDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public void verifyFood(LoginDto loginDto) {
        Optional<FoodEntity> byUsername = foodRepository.findByUsername(loginDto.getUsername());
        if(byUsername.isPresent()){
            FoodEntity entity = byUsername.get();
        }
    }
}
