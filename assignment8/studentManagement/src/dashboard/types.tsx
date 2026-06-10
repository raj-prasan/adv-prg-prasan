export interface Student{
  id: number,
  name: string,
  enrolledCourse: Set<string>,
  gpa:number
}