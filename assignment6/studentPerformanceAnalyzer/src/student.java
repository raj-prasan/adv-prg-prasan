import java.util.*;

class Student {

    int id;
    String name;
    List<String> courses;
    Map<String, Integer> scores;

    public Student(int id, String name, List<String> courses, Map<String, Integer> scores) {
        this.id = id;
        this.name = name;
        this.courses = courses;
        this.scores = scores;
    }

    public double getAverageScore() {
        if (scores.isEmpty()) return 0;

        return scores.values()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}