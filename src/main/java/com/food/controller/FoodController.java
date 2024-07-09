package com.food.controller;

import com.food.dto.FoodDto;
import com.food.dto.LoginDto;
import com.food.repository.FoodRepository;
import com.food.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    private FoodService foodService;

    private FoodRepository foodRepository;

    public FoodController(FoodService foodService, FoodRepository foodRepository) {
        this.foodService = foodService;
        this.foodRepository = foodRepository;
    }
    @PostMapping
    public ResponseEntity<?> addFood(@RequestBody FoodDto foodDto){
        if(foodRepository.exixtsByEmail(foodDto.getEmail())){
            return new ResponseEntity<>("Email exist",HttpStatus.OK);
        }
        if(foodRepository.existsByUsername(foodDto.getUsername())){
            return new ResponseEntity<>("username exists",HttpStatus.OK);
        }

        FoodDto dto = foodService.addFood(foodDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

   /* @PostMapping
    public ResponseEntity<String> verifyLogin(LoginDto loginDto){
        foodService.verifyFood(loginDto);
    }*/
}
