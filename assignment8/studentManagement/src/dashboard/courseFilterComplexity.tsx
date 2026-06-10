type Props = {
  totalStudents: number;
  selectedCourse: string;
  filteredCount: number;
};

export default function CourseFilterComplexity({
  totalStudents,
  selectedCourse,
  filteredCount,
}: Props) {
  const isFiltering = selectedCourse !== "All";

  return (
    <div className="rounded-lg border border-border bg-card p-4 text-left">
      <h2 className="text-base font-semibold">Course Filter Complexity</h2>
      <p className="mt-1 text-sm text-muted-foreground">
        Filtering students by course scans all students once and checks
        membership in each student&apos;s course set.
      </p>

      <div className="mt-3 space-y-1 text-sm">
        <p>
          <span className="font-medium">Operation:</span>{" "}
          <code>studentList.filter((s) =&gt; s.enrolledCourse.has(course))</code>
        </p>
        <p>
          <span className="font-medium">Time Complexity:</span> O(n)
        </p>
        <p>
          <span className="font-medium">Space Complexity:</span> O(k)
        </p>
        <p>
          <span className="font-medium">Current n:</span> {totalStudents}
        </p>
        <p>
          <span className="font-medium">Estimated checks:</span>{" "}
          {isFiltering ? totalStudents : 0}
        </p>
        <p>
          <span className="font-medium">Filtered result size (k):</span>{" "}
          {isFiltering ? filteredCount : totalStudents}
        </p>
      </div>
    </div>
  );
}