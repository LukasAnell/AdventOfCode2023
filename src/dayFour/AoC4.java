package dayFour;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AoC4 {
    public static void main(String[] args) {
        Path path = Paths.get("src/dayOne/Day4Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC4::dayFour);
        } catch (IOException e) {
            System.out.println("Error happened");
        }
    }

    public static void dayFour(String str) {
    }
}
