import type { Student } from "./types";
export const students: Student[] = [
  {id: 24001, name: "Rahul", enrolledCourse: new Set(["TOC"]),gpa: 8.14},
  {id: 24002, name: "Aman", enrolledCourse: new Set(["AP", "DAA"]),gpa: 4.10},
  {id: 24003, name: "Priya", enrolledCourse: new Set(["COA"]),gpa: 9.5},
  {id: 24004, name: "Ram", enrolledCourse: new Set(["COA", "AP", "DAA"]),gpa: 7.4},
]

export  const courses = ["TOC", "COA", "DAA", "AP", "ECONOMICS"];
