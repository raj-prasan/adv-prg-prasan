class Address:
    def __init__(self, street, city, zip_code):
        self.street = street
        self.city = city
        self.zip_code = zip_code

    def __str__(self):
        return f"{self.street}, {self.city} - {self.zip_code}"


class Student:
    def __init__(self, name, age, address):
        self.name = name

        if age<5:
            raise ValueError("Age must be at least 5")
        else:
            self.age = age
        self.address = address
        self.courses = []

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        if not (0 < value < 120):
            raise ValueError("Invalid age")
        self._age = value

    def add_course(self, course):
        self.courses.append(course)

    def display(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"Address: {self.address}")
        print(f"Courses: {', '.join(self.courses)}")


class ScholarshipStudent(Student):
    def __init__(self, name, age, address, scholarshipAmount):
        super().__init__(name, age, address)
        self.scholarshipAmount = scholarshipAmount

    def display(self):
        super().display()
        print(f"Scholarship: {self.scholarshipAmount}")


if __name__ == "__main__":
    addr = Address("MG Road", "Bangalore", "560001")
    try:
        s1 = Student("Prasan", 20, addr)
    except ValueError as e:
        print("Error: ",e)
    s1.add_course("Math")
    s1.add_course("Physics")

    s2 = ScholarshipStudent("Johan ", 21, addr, 50000)
    s2.add_course("CS")

    s1.display()
    print()
    s2.display()

    s1.add_course("Chemistry")
    s1.display()