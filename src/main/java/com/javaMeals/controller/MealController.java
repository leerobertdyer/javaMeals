package com.javaMeals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaMeals.model.Meal;
import com.javaMeals.repository.MealRepository;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

@PostMapping
public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
    // Save meal to the database
    Meal savedMeal = mealRepository.save(meal);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedMeal);
}

    @DeleteMapping
    public void deleteMeal(@RequestParam Long id) {
        mealRepository.deleteById(id);
    }
}
