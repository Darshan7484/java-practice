import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MarksAnalyzer {

    public static void main(String[] args) {

        try {

            // Step 1: Read file and convert to integers
            Stream<Integer> marks = Files.lines(Paths.get("marks.txt"))
                    .map(Integer::parseInt);

            // Step 2: Calculate Total
            int total = Files.lines(Paths.get("marks.txt"))
                    .mapToInt(Integer::parseInt)
                    .sum();

            // Step 3: Calculate Average
            double average = Files.lines(Paths.get("marks.txt"))
                    .mapToInt(Integer::parseInt)
                    .average()
                    .orElse(0);

            // Step 4: Find Highest
            int max = Files.lines(Paths.get("marks.txt"))
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElse(0);

            // Step 5: Print results
            System.out.println("Total = " + total);
            System.out.println("Average = " + average);
            System.out.println("Highest = " + max);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }
}