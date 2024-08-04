package com.javaMeals.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaMeals.model.Meal;
import com.javaMeals.repository.MealRepository;

@RestController  // Let's the code know we are setting up REST
@RequestMapping("/api/meals") // Sets the route for the remainder of this controller
public class MealController {

    private static final Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealRepository mealRepository;

    // Get all meals
    @GetMapping
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    // Get a single meal

    @GetMapping
    public ResponseEntity<Meal> getSingleMeal(@PathVariable String id) {
        Optional<Meal> optionalMeal = mealRepository.findById(id);

        if (!optionalMeal.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optionalMeal.get());
        }
    }

    @PostMapping
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        // Save meal to the database
        Meal savedMeal = mealRepository.save(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMeal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable String id, @RequestBody Meal nextMeal) {
        logger.info("Updating meal with ID: {}", id);
   
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        
        if (!optionalMeal.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Meal meal = optionalMeal.get();
        meal.setName(nextMeal.getName());
        meal.setIngredients(nextMeal.getIngredients());

        Meal updatedMeal = mealRepository.save(meal);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeal(@PathVariable String id) {
        logger.info("Deleting meal with id: " + id);

        Optional<Meal> optionalMeal = mealRepository.findById(id);
        
        if (!optionalMeal.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Meal meal = optionalMeal.get();

        mealRepository.delete(meal);

        return ResponseEntity.ok("meal deleted?");
    }
}
