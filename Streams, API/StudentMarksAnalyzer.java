import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StudentMarksAnalyzer {
    public static void main(String[] args) {
        Path filePath = Paths.get("marks.txt");

        try (Stream<String> lines = Files.lines(filePath)) {

            List<Integer> marks = lines
                                    .map(String::trim)
                                    .filter(line -> !line.isEmpty())
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

            int total   = marks.stream().mapToInt(Integer::intValue).sum();
            double avg  = marks.stream().mapToInt(Integer::intValue).average().orElse(0);
            int highest = marks.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("Marks      : " + marks);
            System.out.println("Total      : " + total);
            System.out.println("Average    : " + avg);
            System.out.println("Highest    : " + highest);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
