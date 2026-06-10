import gc
import weakref


class Node:
    def __init__(self, name):
        self.name = name
        self.link = None

    def __del__(self):
        print(f"{self.name} destroyed")


# Stop automatic garbage collection
gc.disable()

# Create two objects
a = Node("A")
b = Node("B")

# Create circular reference

a.link = b
b.link = a

# Weak references (do not increase refcount)
wa = weakref.ref(a)
wb = weakref.ref(b)

print("Objects alive:")
print(wa() is not None)
print(wb() is not None)

# Delete normal references
del a
del b

print("\nAfter del:")
print("Still alive because of cycle:")
print(wa() is not None)
print(wb() is not None)

# Manually run garbage collector
print("\nRunning gc.collect()...")
gc.collect()

print("\nAfter garbage collection:")
print(wa() is None)
print(wb() is None)

# Enable GC again
gc.enable()