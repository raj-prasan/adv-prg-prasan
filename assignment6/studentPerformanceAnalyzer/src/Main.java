import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Map<String,Integer> scores1 = new HashMap<>();
        scores1.put("Math",85);
        scores1.put("DSA",90);

        Map<String,Integer> scores2 = new HashMap<>();
        scores2.put("Math",75);
        scores2.put("Java",88);

        Map<String,Integer> scores3 = new HashMap<>();
        scores3.put("DSA",95);
        scores3.put("Java",92);

        students.add(new Student(1,"Rahul",
                Arrays.asList("Math","DSA"),scores1));

        students.add(new Student(2,"Anita",
                Arrays.asList("Math","Java"),scores2));

        students.add(new Student(3,"Karan",
                Arrays.asList("DSA","Java"),scores3));


        // Top Students
        List<Student> topStudents =
                StudentAnalyzer.getTopNStudents(students,2);

        System.out.println("Top Students:");
        for(Student s : topStudents)
            System.out.println(s.name + " Avg: " + s.getAverageScore());


        // Average per course
        Map<String,Double> avgCourse =
                StudentAnalyzer.getAverageScorePerCourse(students);

       ("\nAverage Score Per Course:");
        avgCourse.forEach((k,v) ->
                System.out.println(k + " : " + v));


        // Unique Courses
        Set<String> courses =
                StudentAnalyzer.getAllUniqueCourses(students);

        System.out.println("\nAll Unique Courses:");
        courses.forEach(System.out::println);
    }
}