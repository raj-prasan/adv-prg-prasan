import React, { useState } from "react";
import type { Student } from "./types";
import { courses } from "./studentData";
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { Label } from "@/components/ui/label";
import { Input } from "@/components/ui/input";

type Props = {
  studentList: Student[];
  setStudentList: React.Dispatch<React.SetStateAction<Student[]>>;
};

export function AddStudentDialog({ studentList, setStudentList }: Props) {
  const [newStudent, setNewStudent] = useState<
    Omit<Student, "id" | "gpa"> & { id: number | ""; gpa: number | "" }
  >({
    id: "",
    gpa: "",
    enrolledCourse: new Set<string>(),
    name: "",
  });

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button>Add Student</Button>
      </DialogTrigger>

      <DialogContent className="sm:max-w-md">
        <DialogHeader>
          <DialogTitle>Add a new Student</DialogTitle>
          <DialogDescription>add a student</DialogDescription>
        </DialogHeader>

        <div className="flex items-center gap-2">
          {/* ID */}
          <div className="grid flex-1 gap-2">
            <Label htmlFor="studentID">ID</Label>
            <Input
              id="studentID"
              value={String(newStudent.id)}
              onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
                setNewStudent((prev) => ({
                  ...prev,
                  id: Number(e.target.value),
                }))
              }
            />
          </div>

          {/* NAME */}
          <div className="grid flex-1 gap-2">
            <Label htmlFor="studentName">Name</Label>
            <Input
              id="studentName"
              value={newStudent.name}
              onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
                setNewStudent((prev) => ({
                  ...prev,
                  name: e.target.value,
                }))
              }
            />
          </div>
          <div className="grid flex-1 gap-2">
            <Label htmlFor="gpa">GPA</Label>
            <Input
              id="gpa"
              type="number"
              step="0.01"
              min="0"
              max="10"
              value={newStudent.gpa}
              onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
                setNewStudent((prev) => ({
                  ...prev,
                  gpa: Number(e.target.value),
                }))
              }
            />
          </div>
        </div>

        <div className="grid gap-2">
          {courses.map((course) => (
            <div key={course} className="flex items-center gap-2">
              <input
                type="checkbox"
                id={`course-${course}`}
                className="h-4 w-4"
                checked={newStudent.enrolledCourse.has(course)}
                onChange={(e: React.ChangeEvent<HTMLInputElement>) => {
                  setNewStudent((prev) => {
                    const updated = new Set(prev.enrolledCourse);

                    if (e.target.checked) updated.add(course);
                    else updated.delete(course);

                    return {
                      ...prev,
                      enrolledCourse: updated,
                    };
                  });
                }}
              />
              <Label htmlFor={`course-${course}`}>{course}</Label>
            </div>
          ))}
        </div>

        <DialogFooter className="sm:justify-start">
          <DialogClose asChild>
            <Button
              type="button"
              onClick={() => {
                setStudentList((prev) => [
                  ...prev,
                  {
                    ...newStudent,
                    id: Number(newStudent.id) || 0,
                    gpa: Number(newStudent.gpa) || 0,
                  },
                ]);
                setNewStudent({
                  id: "",
                  gpa: "",
                  enrolledCourse: new Set<string>(),
                  name: "",
                });
              }}
            >
              Save
            </Button>
          </DialogClose>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
