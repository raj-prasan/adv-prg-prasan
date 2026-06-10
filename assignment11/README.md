# Library System

Simple Java demo showing inheritance and polymorphism for library items.

## Overview

- `LibraryItem` (abstract): base class with `title`, `year`, and a static `totalItems` counter. Declares `displayInfo()`.
- `Book`: extends `LibraryItem`, adds `author` and overrides `displayInfo()`.
- `DVD`: extends `LibraryItem`, adds `duration` and `genre` and overrides `displayInfo()`.
- `Main`: demo program that creates a list of items, prints their info, and shows total items.

## Features

- Demonstrates inheritance, method overriding, and a static class counter.
- Uses an overloaded constructor in `LibraryItem`.

## Files

- `src/LibraryItem.java` — abstract base class.
- `src/Book.java` — `Book` implementation.
- `src/DVD.java` — `DVD` implementation.
- `src/Main.java` — runnable demo.

## Requirements

- Java 8 or later

## Build & Run

From the `assignment11/LibrarySystem` directory:

```bash
javac -d out src/*.java
java -cp out Main
```

Or compile in-place:

```bash
javac src/*.java
java -cp src Main
```

## Example Output

When run, the program prints each item's info and the total number of items, for example:

```
Book: Java Basics, Author: James Gosling, Year: 2020
DVD: Inception, Genre: Sci-Fi, Duration: 148 mins, Year: 2010
Book: DSA Guide, Author: John Doe, Year: 2005
Total items: 3
```

## Suggestions

- Add methods to borrow/return items and track availability.
- Add unit tests and package into a proper `src`/`bin` layout or a build tool (`maven`/`gradle`).
