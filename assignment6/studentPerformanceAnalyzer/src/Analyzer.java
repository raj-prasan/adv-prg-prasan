import java.util.*;
import java.util.stream.*;

class StudentAnalyzer {

    // 1. Get Top N Students
    public static List<Student> getTopNStudents(List<Student> students, int n) {

        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageScore).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    // 2. Average Score Per Course
    public static Map<String, Double> getAverageScorePerCourse(List<Student> students) {

        Set<String> courses = getAllUniqueCourses(students);

        Map<String, Double> avgMap = new HashMap<>();

        for (String course : courses) {

            double avg = students.stream()
                    .mapToInt(s -> s.scores.getOrDefault(course, 0))
                    .average()
                    .orElse(0);

            avgMap.put(course, avg);
        }

        return avgMap;
    }

    // 3. Get All Unique Courses
    public static Set<String> getAllUniqueCourses(List<Student> students) {

        return students.stream()
                .flatMap(s -> s.courses.stream())
                .collect(Collectors.toSet());
    }
}