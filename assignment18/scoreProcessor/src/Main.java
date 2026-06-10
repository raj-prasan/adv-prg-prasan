import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String fileName = "score.txt";

        try {

            // Process the file
            ScoreProcessor processor = new ScoreProcessor();
            int result = processor.processScoreFile(fileName);

            System.out.println("Processed Score: " + result);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

    }
}