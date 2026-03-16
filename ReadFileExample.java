import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadFileExample {

    public static void main(String[] args) {

        try {
            
            // Step 1: Read file as Stream
            Stream<String> lines = Files.lines(Paths.get("user.txt"));

            // Step 2: Print each line
            lines.forEach(line -> System.out.println(line));

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }
}