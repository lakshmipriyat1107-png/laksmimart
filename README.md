# PriyaMart

Spring Boot online shopping web application built from the supplied PriyaMart HTML pages.

## Stack
Java 17 | Spring Boot | Maven | H2 | Spring JDBC/JdbcTemplate | HTML/CSS/JavaScript

## Pages
`/` home, `/login.html`, `/register.html`, `/buyer.html`, `/seller.html`, `/admin.html`, `/h2-console`

## Demo accounts
Admin: `admin@priyamart.com` / `admin123`
Seller: `seller@priyamart.com` / `seller123`
Buyer: `buyer@priyamart.com` / `buyer123`

## Run
Open Command Prompt inside the PriyaMart folder and run:
`mvn clean spring-boot:run`

Then open `http://localhost:8080/`.

## H2 Console
Open `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:priyamart`
User: `sa`
Password: blank

## Notes
The supplied pages are retained in `src/main/resources/static`. The browser JavaScript now calls Spring Boot JDBC APIs for registration, login, products and cart operations.

This is a learning/demo project. Passwords are intentionally plain text for simplicity; production software should hash passwords and use proper authentication/authorization.


UI update: removed visible logo elements and added local product images in src/main/resources/static/images.
