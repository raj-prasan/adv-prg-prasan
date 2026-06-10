import { useState } from "react";
import { courses, students } from "./studentData";
import type { Student } from "./types";
import StudentTable from "./table";
import { AddStudentDialog } from "./addStudentDialog";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import CourseFilterComplexity from "./courseFilterComplexity";

export default function StudentList() {
  const [studentList, setStudentList] = useState<Student[]>(students);
  const [deleteId, setDeleteId] = useState("");
  const [selectedCourse, setSelectedCourse] = useState("All");

  const filteredStudents =
    selectedCourse === "All"
      ? studentList
      : studentList.filter((student) => student.enrolledCourse.has(selectedCourse));

  const deleteStudent = (id: number) => {
    setStudentList((prev) => prev.filter((student) => student.id !== id));
  };

  const sortByGpa = () => {
    setStudentList((prev) => [...prev].sort((a, b) => b.gpa - a.gpa));
  };

  return (
    <div className="flex flex-col gap-1.5">
      <div className="flex items-center gap-2">
        <AddStudentDialog
          studentList={studentList}
          setStudentList={setStudentList}
        />

        <Input
          type="number"
          placeholder="Student ID"
          value={deleteId}
          onChange={(e) => setDeleteId(e.target.value)}
          className="w-32"
        />
        <Button
          className="my-5"
          onClick={() => {
            if (deleteId) {
              deleteStudent(Number(deleteId));
              setDeleteId("");
            }
          }}
        >
          Remove by ID
        </Button>

        <Button className="my-5" onClick={sortByGpa}>
          Sort by GPA
        </Button>

        <select
          value={selectedCourse}
          onChange={(e) => setSelectedCourse(e.target.value)}
          className="h-9 rounded-md border border-input bg-background px-3 text-sm"
        >
          <option value="All">All Courses</option>
          {courses.map((course) => (
            <option key={course} value={course}>
              {course}
            </option>
          ))}
        </select>
      </div>

      <CourseFilterComplexity
        totalStudents={studentList.length}
        selectedCourse={selectedCourse}
        filteredCount={filteredStudents.length}
      />

      <StudentTable data={filteredStudents} />
    </div>
  );
}
