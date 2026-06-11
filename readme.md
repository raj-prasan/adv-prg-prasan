# Time Complexity Analysis - time_mes.c Assignment

## Objective
Analyze and compare time complexities of algorithms with **constant time O(1)**, **linear time O(n)**, and **quadratic time O(n²)** by measuring execution time across varying input sizes.

## Problem Statement
Write a C program that:
1. Implements functions demonstrating constant, linear, and quadratic time complexities
2. Measures execution time for each algorithm
3. Tests with progressively larger input sizes
4. Displays and compares the time consumed for each complexity class

## Key Concepts

### Time Complexity Classes
- **O(1) - Constant Time**: Execution time remains constant regardless of input size
- **O(n) - Linear Time**: Execution time grows proportionally with input size
- **O(n²) - Quadratic Time**: Execution time grows with the square of input size

## Implementation Requirements

### Functions to Implement
1. **Constant Time Algorithm** - e.g., accessing array element, simple calculation
2. **Linear Time Algorithm** - e.g., sum of array elements, linear search
3. **Quadratic Time Algorithm** - e.g., nested loops, bubble sort

### Input Size Progression
Test with input sizes: 1000, 5000, 10000, 50000, 100000, etc.

### Measurement
- Use `clock()` or `time()` functions to measure execution time
- Calculate time in milliseconds or microseconds
- Display results in a tabular format

## Expected Output
A comparison table showing:
| Input Size | O(1) Time | O(n) Time | O(n²) Time |
|-----------|-----------|-----------|-----------|
| 1000      | time_ms   | time_ms   | time_ms   |
| 5000      | time_ms   | time_ms   | time_ms   |
| 10000     | time_ms   | time_ms   | time_ms   |

## Observations
- O(1) should remain nearly constant
- O(n) should increase linearly
- O(n²) should increase exponentially with input size

## Sample Code Structure
```c
#include <stdio.h>
#include <time.h>

// O(1) - Constant Time
int constantTime(int arr[], int n) {
    // Simple operation
}

// O(n) - Linear Time
int linearTime(int arr[], int n) {
    // Loop through array once
}

// O(n²) - Quadratic Time
int quadraticTime(int arr[], int n) {
    // Nested loops
}

int main() {
    // Implement timer and test with increasing input sizes
}
```

## Compilation & Execution
```bash
gcc -o time_mes time_mes.c
./time_mes
```

## Learning Outcomes
- Understand practical differences between time complexities
- Learn to measure and analyze algorithm performance
- Visualize how complexity affects execution time with real data
- 
