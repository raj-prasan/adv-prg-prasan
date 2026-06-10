# Dynamic String Buffer

This C program demonstrates a dynamically growing string buffer implemented with manual heap management.

## Overview

The program defines a `StringBuffer` structure that stores:

- `data` - a heap-allocated, null-terminated character array
- `length` - the number of characters currently stored
- `capacity` - the allocated size of the buffer in bytes

The demo in `main()` initializes a buffer, appends several strings, prints the internal state after each append, and frees all memory at the end.

## Functions

- `sb_init(size_t initial_capacity)`
  - Creates a new buffer on the heap.
  - Uses a minimum capacity of 1 if the requested capacity is 0.
  - Returns `NULL` if allocation fails.

- `sb_append(StringBuffer *sb, const char *str)`
  - Appends a string to the buffer.
  - Automatically grows the buffer by doubling capacity until it can hold the new data.
  - Returns `1` on success and `0` on failure.

- `sb_free(StringBuffer **sb)`
  - Releases the buffer memory.
  - Sets the caller's pointer to `NULL` to avoid dangling references.

## Behavior Demonstrated

- Dynamic growth using `realloc()`
- Safe cleanup of heap memory
- Tracking buffer length and capacity
- Printing internal buffer state for debugging

## Build & Run

Use any C compiler such as `gcc` or `clang`.

```bash
gcc dynamicStringBuffer.c -o dynamicStringBuffer
./dynamicStringBuffer
```

On Windows with MinGW:

```bash
gcc dynamicStringBuffer.c -o dynamicStringBuffer.exe
dynamicStringBuffer.exe
```

## Example Output

The program prints messages showing when the buffer grows, what gets appended, and the final buffer contents.

## Notes

- The code uses `malloc`, `realloc`, and `free`, so every allocation path must be checked.
- The buffer growth strategy doubles capacity until it fits the required size.
- `sb_free()` accepts a pointer to the pointer so it can null out the original reference after freeing.

