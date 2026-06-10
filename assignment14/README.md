# Assignment 14 — Garbage Collection Demo

This Python script demonstrates how circular references interact with garbage collection, using `gc` and `weakref`.

## What the Script Does

- Defines a `Node` class with a `link` field.
- Creates two nodes, `A` and `B`, and links them in a cycle.
- Creates weak references to both objects.
- Disables automatic garbage collection.
- Deletes the strong references and shows that the objects are still alive because of the cycle.
- Calls `gc.collect()` to clean up the cycle.
- Re-enables garbage collection at the end.

## Key Concepts

- **Circular reference:** `A` points to `B` and `B` points back to `A`.
- **Weak reference:** `weakref.ref()` does not increase reference count.
- **Garbage collection:** `gc.collect()` is used to manually reclaim cyclic objects.

## Run

From the `assignment14` directory:

```bash
python demo.py
```

## Expected Output

The script prints that both objects are alive before deletion, still alive after `del a` and `del b`, and then destroyed after `gc.collect()` runs.

## Notes

- `__del__` shows when each object is destroyed.
- `gc.disable()` is used so the cycle remains until manual collection.
- `gc.enable()` restores normal garbage collection.
