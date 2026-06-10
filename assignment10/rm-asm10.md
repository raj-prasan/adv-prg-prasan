# Assignment 10 — Student Records (README)

This small Python program demonstrates simple OOP concepts: composition, inheritance, property validation, and a basic interactive example.

## Overview

- `Address` — stores `street`, `city`, and `zip_code`, and provides a readable `__str__` representation.
- `Student` — represents a student with `name`, validated `age`, `address`, and a list of `courses`.
  - Age is validated in the constructor (must be >= 5) and by the `age` setter (must be 0 < age < 120).
  - Methods: `add_course(course)` and `display()` to print student details.
- `ScholarshipStudent` — subclass of `Student` that adds `scholarshipAmount` and extends `display()` to show it.

## Example Behavior

The `__main__` section creates an `Address`, a `Student`, and a `ScholarshipStudent`, adds courses, and prints their details. Errors (like invalid ages) are caught and printed.

## Files

- `main.py` — contains all classes and the sample usage.

## Requirements

- Python 3.6+

## Run

From the `assignment10` directory run:

```bash
python main.py
```

## Notes & Suggestions

- Consider splitting classes into separate modules for larger projects.
- Add unit tests for age validation and course management.
- Improve input handling to allow interactive creation of students.
