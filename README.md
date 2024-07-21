#  Building a Filter and Sort API

# Product Filtering and Sorting API

This API allows clients to filter and sort products based on category, price range, stock availability, and sort criteria.

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
