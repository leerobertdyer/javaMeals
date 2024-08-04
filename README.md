# JavaMeals

JavaMeals is a simple RESTful API application built with JAVA and Spring Boot to manage a collection of meals. The application allows you to perform basic CRUD operations on meal data.

### API Endpoints

- **GET /api/meals**
  - Retrieves a list of all meals.
  
- **POST /api/meals**
  - Adds a new meal. 
  - **Request Body Example:**
    ```json
    {
      "name": "Spaghetti Bolognese",
      "ingredients": ["spaghetti", "minced meat", "tomato sauce"]
    }
    ```

- **DELETE /api/meals**
  - Deletes a meal by its ID.
  - **Query Parameter Example:**
    ```
    ?id=1
    ```

## Contributing

Feel free to open issues or submit pull requests if you have improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

