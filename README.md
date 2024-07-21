# Product Filtering and Sorting API

This API allows clients to filter and sort products based on category, price range, stock availability, and sort criteria.



## **Getting Started**
To run the Food Delivery Application locally, follow these steps:

### 1. Clone the repository: 
   ```
   https://github.com/gaurav637/Food-Delivery-App
   ```
**2.** Navigate to the project directory: cd food-delivery-app

**3.** Open the project in your IDE: Eclipse (recommended) or IntelliJ IDEA
       If you are using Eclipse, make sure the IDE opens project as Maven and recognizes the project as a Spring Boot project.
       
**4.** Configure the database connection in application.properties:
 MySQL can be used as the database for this project. The database connection can be configured in the 
 application.properties file, with the appropriate 
 values for the following properties: (you'd better use another username not root)
       
 ```
    db.url=jdbc:mysql://[ip address of db]:[port of db]/database_name
    db.username=[username]
    db.password=[password, if any]
 ```
       
**5.** Build the project:``` mvn clean package```

**6.** Run the application:``` java -jar target/food-delivery-app.jar```

**7.** Access the application in your web browser at: http://localhost:9192


















## Endpoints

### 1. Get Filtered and Sorted Products

**URL**: `/api/filter/products`

**Method**: `GET`

**Description**: Fetches a list of products based on the provided filters and sorts them according to the specified field and order.

**Parameters**:
- `category` (String, required): The category of the products to filter.
- `minPrice` (Double, required): The minimum price of the products to filter.
- `maxPrice` (Double, required): The maximum price of the products to filter.
- `inStock` (Boolean, required): Availability of the products in stock.
- `sortField` (String, required): The field to sort the products by (e.g., `price`, `rating`).
- `sortOrder` (String, required): The order of sorting (`asc` for ascending, `desc` for descending).

**Sample Request**:
