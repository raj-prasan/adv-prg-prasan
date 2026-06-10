import type { Student } from "./types";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

type Props = {
  data: Student[];
};
export default function StudentTable({ data }: Props) {
  return (
    <Table>
      <TableHeader>
        <TableRow>
          <TableHead>ID</TableHead>
          <TableHead>Name</TableHead>
          <TableHead>Enrolled Courses</TableHead>
          <TableHead>GPA</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {data.map((student) => (
          <TableRow key={student.id}>
            <TableCell>{student.id}</TableCell>
            <TableCell>{student.name}</TableCell>
            <TableCell>
              {Array.from(student.enrolledCourse).join(", ")}
            </TableCell>
            <TableCell>{student.gpa}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}
