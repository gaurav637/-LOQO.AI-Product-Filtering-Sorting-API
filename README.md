# Product Filtering and Sorting API



This API allows clients to filter and sort products based on category, price range, stock availability, and sort criteria.



## **Getting Started**

  To run the product filtering and sorting application locally, follow these steps:

### 1. Clone the repository: 
   ```
     https://github.com/gaurav637/Product-Filtering-Sorting-API
   ```
### 2. Navigate to the project directory:

  ```
    cd LoqoApplication
  ```

### 3. Open the project in your IDE: 

  Eclipse (recommended) or IntelliJ IDEA If you are using Eclipse, make sure the IDE opens project as Maven and 
  recognizes the project as a Spring Boot project.
       
### 4. Configure the database connection in application.properties:

   MongoDB can be used as the database for this project. The database connection can be configured in the 
   application.properties file, with the appropriate 
   values for the following properties: (you'd better use another username not root)
       
 ```
    spring.data.mongodb.uri=mongodb://[ip address of db]:[port of db]/database_name
    spring.data.mongodb.database=database_name

 ```
       
### 5. Build the project:
 
 ```
   mvn clean package
```

### 6. Run the application:

  ``` 
   java -jar target/LoqoApplication.jar
  ```

### 7. Access the application in your web browser at: 

  ``` 
  http://localhost:8080
 ```

## Features
```
    {
        "id": "669b55e40e1cd36e4e35056f",
        "name": "Realme",
        "category": "Android",
        "price": 909.21,
        "inStock": false,
        "rating": 3.4,
        "createdAt": "2024-07-20T06:14:59.835+00:00"
    }
```
   ### Product
   - Create Products
   - Get Products By Id
   - Get All Produts
   - Update Products
   - Delete Products
       
   ### Filter Products
   - Filter By Category
   - Filter By Price
   - Filter By InStock
   - Filter By CreatedAt

   ### Sort Products    
   - Sort By price
   - Sort By Rating
   - Sort By CreatedAt

## Requirements

1. Java Development Kit (JDK)
2. Maven
3. Database(MONGODB)
4. Eclipse IDE
5. Postman
6. Terminal
7. Browser

## Skills and Expertise

1. Java Programming
2. Spring Framework
3. Spring Boot
4. Database Management
5. RESTful APIs
6. Version Control
7. Problem-Solving Skills
8. Testing and Debugging


## API Documentation

[POSTMAN](https://documenter.getpostman.com/view/32384477/2sA3kUHN6K)



## API Endpoints


### Create a New Product

- **Endpoint:** `POST /product-api/create/new`
- **Description:** Creates a new product.
- **Request Body:**
  ```json
  {
    "name": "Product Name",
    "description": "Product Description",
    "price": 100.0,
    "category": "Category"
  }
  
- Response:
  - 201 Created
    ```json
      {
          "id": "productId",
          "name": "Product Name",
          "description": "Product Description",
          "price": 100.0,
          "category": "Category"
       }
    ```
  - 500 Internal Server Error
    ```json
     {
       "error": "Failed to create new Product: Error Message"
     }
    ```

### Get All Products

- **Endpoint:** GET /product-api/get/all-products
- **Description:** Retrieves a list of all products.
- **Response:**
   - 200 OK
       ```json
        [
          {
            "id": "productId1",
            "name": "Product Name 1",
            "description": "Product Description 1",
            "price": 100.0,
            "category": "Category 1"
          },
          {
            "id": "productId2",
            "name": "Product Name 2",
            "description": "Product Description 2",
            "price": 150.0,
            "category": "Category 2"
          }
        ]

      ```
  - 500 Internal Server Error
    
    ```json
        {
           "error": "Failed to get all product data: Error Message"
        }
    ```       

### Get Product by ID

- **Endpoint:** GET /product-api/get/product-by-id/{productId}
- **Description:** Retrieves a product by its ID.
- URL Parameters:
- **productId:** The ID of the product to retrieve.
- Response:
    - 200 OK
       ```json
        {
          "id": "productId",
          "name": "Product Name",
          "description": "Product Description",
          "price": 100.0,
          "category": "Category"
        }

       ```
   - 500 Internal Server Error
     ```json
      {
        "error": "Failed to get product by productId: Error Message"
      }

     ```
     
### Update Product

- **Endpoint:** PUT /product-api/update/product/{productId}
- **Description:** Updates the properties of an existing product.
- URL Parameters:
- **productId:** The ID of the product to update.
- Request Body:
     ```json
       {
          "name": "Updated Product Name",
          "description": "Updated Product Description",
          "price": 120.0,
          "category": "Updated Category"
       }
     ```
- Response:
   - 200 OK
     ```json
       {
          "id": "productId",
          "name": "Updated Product Name",
          "description": "Updated Product Description",
          "price": 120.0,
          "category": "Updated Category"
       }
     ```
- 500 Internal Server Error
   ```json
    {
      "error": "Failed to update products: Error Message"
    }
   ```     
### Delete Product
- **Endpoint:** DELETE /product-api/delete/product/{productId}
- **Description:** Deletes a product by its ID.
- URL Parameters:
- **productId:** The ID of the product to delete.
- Response:
  - 200 OK
    ```json
       {
          "message": "Product successfully deleted",
          "success": "true"
      }

    ```
 - 500 Internal Server Error
    ```json
       {
          "error": "Failed to delete product: Error Message",
          "success": "false"
       }
    ```   

## Contributing

Contributions are welcome! Please follow these guidelines:
- Fork the repository
- Create a new branch (`git checkout -b feature`)
- Make changes and commit them (`git commit -am 'Add new feature'`)
- Push to the branch (`git push origin feature`)
- Create a pull request

## Contact
For any questions or feedback, please reach out to : negigaurav637@gmail.com

Happy coding!
