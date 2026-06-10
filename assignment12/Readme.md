# Order System (Assignment 12)

This small Java-based order processing system demonstrates a SOLID design for creating orders, processing payments, sending notifications, and saving orders to different storage backends.

## Goals

- Support multiple payment methods (Credit Card, UPI, Wallet)
- Support multiple notification channels (Email, SMS, Push)
- Support different order types (RegularOrder, DiscountedOrder, PriorityOrder)
- Support multiple storage mechanisms (File, Database)
- Follow SOLID principles (SRP, OCP, LSP, ISP, DIP)
## Project Structure

- `src/order/Order.java` — base order abstraction. [src/order/Order.java](src/order/Order.java#L1)
- `src/order/RegularOrder.java` — regular order implementation. [src/order/RegularOrder.java](src/order/RegularOrder.java#L1)
- `src/order/DiscountedOrder.java` — discounted order (10% off). [src/order/DiscountedOrder.java](src/order/DiscountedOrder.java#L1)
- `src/order/PriorityOrder.java` — adds a priority fee. [src/order/PriorityOrder.java](src/order/PriorityOrder.java#L1)

- `src/payment/PaymentMethod.java` — small payment interface (ISP). [src/payment/PaymentMethod.java](src/payment/PaymentMethod.java#L1)
- `src/payment/CreditCardPayment.java`, `UPIPayment.java`, `WalletPayment.java` — concrete payment implementations. [src/payment/CreditCardPayment.java](src/payment/CreditCardPayment.java#L1)

- `src/notification/NotificationService.java` — notification interface. [src/notification/NotificationService.java](src/notification/NotificationService.java#L1)
- `src/notification/EmailNotification.java`, `SMSNotification.java`, `PushNotification.java` — notification implementations. [src/notification/EmailNotification.java](src/notification/EmailNotification.java#L1)

- `src/storage/OrderRepository.java` — repository abstraction. [src/storage/OrderRepository.java](src/storage/OrderRepository.java#L1)
- `src/storage/FileRepository.java`, `DatabaseRepository.java` — concrete storage backends. [src/storage/FileRepository.java](src/storage/FileRepository.java#L1)

- `src/service/OrderService.java` — high-level service that coordinates payment, storage, and notification using dependency injection. [src/service/OrderService.java](src/service/OrderService.java#L1)
- `src/Main.java` — small demo UI that wires implementations and runs a sample order. [src/Main.java](src/Main.java#L1)

## How This Design Applies SOLID

- **SRP (Single Responsibility):**
  - `Order` classes only handle order calculation logic.
  - Payment classes only handle payment processing.
  - Notification classes only handle sending messages.
  - Repository classes only handle persistence.

- **OCP (Open/Closed):**
  - To add a new payment method, implement `PaymentMethod` and provide it to `OrderService` — no changes to existing classes.
  - To add a notification channel, implement `NotificationService` and pass it to `OrderService`.

- **LSP (Liskov Substitution):**
  - All `Order` subclasses (`RegularOrder`, `DiscountedOrder`, `PriorityOrder`) correctly implement `calculateTotal()` and can be used where `Order` is expected.
  - Payment and notification implementations follow their interfaces and return / behave consistently.

- **ISP (Interface Segregation):**
  - Interfaces are small and role-specific (`PaymentMethod`, `NotificationService`, `OrderRepository`) so implementations aren't forced to provide unrelated behavior.

- **DIP (Dependency Inversion):**
  - `OrderService` depends on abstractions (`PaymentMethod`, `NotificationService`, `OrderRepository`) and receives concrete implementations via constructor injection.

## How to Run

From the `orderSystem` directory:

```bash
javac -d out src/**/*.java
java -cp out Main
```

The `Main` demo will prompt to choose a payment method and then process a `DiscountedOrder` using the chosen payment, save it to file, and send an email notification by default.

## Extending the System

- Add a new payment method:
  1. Create a class implementing `PaymentMethod` in `src/payment`.
 2. Wire it into `Main` (or use a DI container) and pass it to `OrderService`.

- Add a new notification channel:
  1. Implement `NotificationService` in `src/notification`.
 2. Provide it to `OrderService`.

- Add a new storage backend:
  1. Implement `OrderRepository` in `src/storage`.
 2. Provide it to `OrderService`.

## Possible Improvements

- Replace manual wiring in `Main` with a dependency injection framework to simplify configuration.
- Add unit tests for `Order` subclasses, payment methods, and `OrderService` behavior.
- Make the notification wiring support multiple channels (e.g., publish to a list of `NotificationService` instances).
- Add configurable discounts/promo rules via a dedicated strategy or policy object.

## Files to Inspect

- [src/order/Order.java](src/order/Order.java#L1)
- [src/payment/PaymentMethod.java](src/payment/PaymentMethod.java#L1)
- [src/notification/NotificationService.java](src/notification/NotificationService.java#L1)
- [src/storage/OrderRepository.java](src/storage/OrderRepository.java#L1)
- [src/service/OrderService.java](src/service/OrderService.java#L1)

---
