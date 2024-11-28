# Test Answers

## 1. How long did you spend on the test? What would you add if you had more time?

I spent approximately 24 hours creating all the code, setting up the test environment with Docker Compose, and preparing the project description on GitHub. If I had more time, I would create a product registration feature with or without promotions via the API to further enrich the project's challenge.

## 2. What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that shows how you've used it.

Utilizei o operador `->` para melhor entendimento do código do switch.

```
switch (promotion.getType()) {
    case "QTY_BASED_PRICE_OVERRIDE" -> {
        // Código...
    }
    case "BUY_X_GET_Y_FREE" -> {
        // Código...
    }
    case "FLAT_PERCENT" -> {
        // Código...
    }
    default -> throw new UnsupportedOperationException("Promoção não suportada: " + promotion.getType());
}
```

## 3. What did you find most difficult?

The most challenging part was defining a unified error response structure to standardize errors and prevent unhandled exceptions from being exposed to the client while ensuring proper logging for analysis.

## 4. What mechanism did you put in place to track down issues in production on this code? If you didn’t put anything, write down what you could do.

I implemented standardized responses with detailed logs for each error, facilitating issue tracking in production.

## 5. Explain your interpretation of the list of requirements and what was delivered or not delivered and why.

The requirements were clear and objective: the customer should be able to make a purchase with a list of items in any order, apply quantity-based promotions, and display the total amount and discounts received. Everything was delivered, but I believe improving the details of the applied discounts would be an interesting enhancement.