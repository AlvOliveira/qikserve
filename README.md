# QikServe Engineer Technical Test
An API for a checkout system for a local supermarket. This solution is designed to calculate the total cost of a basket, which can contain any combination of items and promotions.

- Items can be added in any order.
- Promotions must be applied whenever applicable.
- The store owner requires a display of customer savings.
- Additional prices or promotion types may be introduced in the future.
- The Wiremock server is used with predefined API mappings. This API fetches live data for the application.
- Prices are expressed in pennies.

# Non-Functional Requirements
- The application must be built using Java with Spring Boot on JDK 23.
- Only the Wiremock API should be used to fetch product and promotion data.

# Application to Be Developed
The goal is to create an API for a local supermarket where customers can:

- Make a purchase with a list of items in no specific order.
- Apply quantity-based promotions.
- Display the total cost and the discounts applied.

# Environment Setup Instructions

Navigate to the qikserve directory and run the following command:

```
docker-compose --project-name qikserve-tech-api up --build -d
```  

Wait at least 30 seconds for the application to become operational.

Access the product list via the following browser link (GET request):
```
http://localhost:8080/api/products
```

## Testing Instructions via curl.

## Example: Listing all products (API **"products"**)
Navigate to the qikserve directory and execute the following commands:

For Windows:
```
testGetProduts.cmd
```
For Linux/MacOS:
```
chmod +x testGetProduts.sh

testGetProduts.sh
```

## Example: Fetching a product by ID (API **"product"**)
Navigate to the qikserve directory and execute the following commands:

For Windows:
```
testGetProdutById.cmd
```
For Linux/MacOS
```
chmod +x testGetProdutById.sh

testGetProdutById.sh
```

## Example: Calculating a basket's total (API **"checkout"**)
Navigate to the qikserve directory and execute the following commands:

For Windows:
```
testCheckout.cmd
```
For Linux/MacOS
```
chmod +x testCheckout.sh

testCheckout.sh
```