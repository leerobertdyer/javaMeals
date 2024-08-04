package com.javaMeals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaMeals.model.Meal;

public interface MealRepository extends MongoRepository<Meal, Long> {
}
