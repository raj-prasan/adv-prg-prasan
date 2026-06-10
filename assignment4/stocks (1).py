
products = [
    {"name": "Pen", "stock": 25},
    {"name": "Notebook", "stock": 8},
    {"name": "Eraser", "stock": 5},
    {"name": "Marker", "stock": 12},
    {"name": "Pencil", "stock": 3},
    {"name": "Stapler", "stock": 15}
]

print("Products with stock less than 10:\n")

# Searching condition
for product in products:
    if product["stock"] < 10:
        print("Product:", product["name"], "| Stock:", product["stock"])
