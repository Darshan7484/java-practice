import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        Path filePath = Paths.get("user.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
