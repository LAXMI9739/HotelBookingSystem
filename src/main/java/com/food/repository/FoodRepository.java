package com.food.repository;

import com.food.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
  boolean exixtsByEmail(String email);
  boolean existsByUsername(String Username);
  Optional<FoodEntity> findByUsername(String username);

}