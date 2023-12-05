package dayFive;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AoC5 {
    public static void main(String[] args) {
        Path path = Paths.get("src/dayFive/Day5Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC5::partOne);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }


    }

    public static void partOne(String str) {

    }
}
