package com.javaMeals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meals")
public class Meal {
    @Id
    private String id;
    private String name;
    private String[] ingredients;

    public Meal() {}

    public Meal(String id, String name, String[] ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String[] getIngredients() { return ingredients; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setIngredients(String[] ingredients) { this.ingredients = ingredients; }
}
