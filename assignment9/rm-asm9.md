# Banking System

Simple Java console-based banking system demonstrating inheritance and basic account operations.

## Features
- Create a `SavingsAccount` or `CurrentAccount`.
- Deposit and withdraw funds with validation.
- Savings accounts support an interest rate field.
- Current accounts support an overdraft limit.
- Interactive menu-driven console UI in `Main`.

## Project Structure

- `src/Account.java` — abstract base class providing common account fields and behaviors (`deposit`, `withdraw`, `getBalance`, `displayBalance`).
- `src/SavingsAccount.java` — extends `Account`; stores `interestRate` and overrides `displayBalance`.
- `src/CurrentAccount.java` — extends `Account`; supports an `overdraftLimit` and allows withdrawals up to balance + overdraft.
- `src/Main.java` — console entry point with a menu to interact with an account.

## Requirements
- Java 8 or later

## Build & Run

From the `bankingSystem` directory run:

```bash
javac -d out src/*.java
java -cp out Main
```

Alternatively (compile in-place):

```bash
javac src/*.java
java -cp src Main
```

## Usage
1. Run the program.
2. Choose account type (1 = Savings, 2 = Current).
3. Enter account number, owner name, and initial balance.
4. For savings, enter interest rate; for current, enter overdraft limit.
5. Use the menu to deposit, withdraw, display balance, or exit.

The program prints errors (e.g., invalid amounts, insufficient funds, overdraft exceeded) and continues the menu loop.

## Notes & Suggestions
- `Account` throws on invalid constructor usage (no-arg constructor is not allowed).
- Withdrawal and deposit operations validate amounts and may throw `IllegalArgumentException` on invalid input.
- Possible improvements: persistent storage, interest calculation, unit tests, and input validation enhancements.

## License
Unlicensed — use as-is for learning and assignments.
