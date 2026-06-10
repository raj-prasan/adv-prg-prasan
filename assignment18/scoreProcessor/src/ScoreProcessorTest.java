import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void testValidScoreCalculation() throws Exception {

        File file = tempDir.resolve("score.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("8");
        }

        ScoreProcessor processor = new ScoreProcessor();

        int result = processor.processScoreFile(file.getAbsolutePath());

        assertEquals(80, result);
    }

    @Test
    void testMissingFile() {

        ScoreProcessor processor = new ScoreProcessor();

        assertThrows(
                FileNotFoundException.class,
                () -> processor.processScoreFile("missingFile.txt")
        );
    }

    @Test
    void testInvalidNumberFormat() throws Exception {

        File file = tempDir.resolve("invalid.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("ABC");
        }

        ScoreProcessor processor = new ScoreProcessor();

        assertThrows(
                NumberFormatException.class,
                () -> processor.processScoreFile(file.getAbsolutePath())
        );
    }
}