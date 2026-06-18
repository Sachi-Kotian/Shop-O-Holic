# Shop-O-Holic 

A console-based shopping application built in core Java to practice OOP design, Collections, and the Stream API.

## Stage 1 — Console App (Current)

This stage focuses on clean OOP design before introducing any framework (Spring Boot comes in a later stage). All data is stored in memory ,no database is used yet.

### Features

- Product catalog with search/filter (by name, by category) using Streams
- User registration & login (in-memory)
- Shopping cart — add, remove, update quantity, view total
- Wishlist per user
- Checkout simulation with order summary (date, items, total)
- Stock validation when adding to cart

### Tech / Concepts Used

- Core OOP (encapsulation, classes, constructors)
- Collections — `ArrayList`, `HashMap`
- Stream API + Lambda expressions (`filter`, `toList`, `forEach`)
- `Optional<T>` for safe lookups instead of returning `null`
- `LocalDateTime` for order timestamps

### Project Structure

```
com.shopoholic
├── model/        → Product, User, Cart, Order
├── service/       → ProductCatalog
└── Main.java      → console menu / entry point
```

### How to Run

1. Clone the repo and open it in IntelliJ (or any Java IDE)
2. Run `Main.java`
3. Follow the on-screen menu

---

## Known Limitations (Stage 1)

This is a learning-stage console app, so some simplifications were made on purpose. These are documented here rather than fixed now, since most are better solved once a database/session layer (Spring Boot, Stage 3) is introduced.

- **Cart is global, not per-user.** There's a single shared `Cart` instance for the whole app session rather than one cart per logged-in user. This works correctly as long as a user checks out before another user logs in, but isn't a safe multi-user design.
- **No data persistence.** All users, products, and orders live in memory (`ArrayList`/`HashMap`). Restarting the program wipes all registered users and order history.
- **Passwords are stored in plain text.** No hashing (e.g. BCrypt) is used yet — acceptable for a console learning project, not for production.
- **No duplicate email check.** Registration doesn't currently prevent two users from signing up with the same email.
- **Limited input validation.** Non-numeric input where a number is expected (e.g. menu choice, quantity) will throw an `InputMismatchException` rather than being handled gracefully.
- **Stock isn't reduced after checkout.** Placing an order doesn't currently decrement the product's stock count, so the same item can be "ordered" indefinitely.
- **No order history.** Orders are printed to the console at checkout but not stored anywhere, so a user can't view past orders.
- **No duplicate check on wishlist.** The same product can be added to a user's wishlist multiple times.

