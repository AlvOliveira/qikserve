#!/bin/bash

curl -X POST http://localhost:8080/api/checkout \
-H "Content-Type: application/json" \
-d '[{"productId":"PWWe3w1SDU","quantity":3},{"productId":"C8GDyLrHJb","quantity":2}]'
