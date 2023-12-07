package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<String> readFromFile(String fileName) {
        List<String> calibrations = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                calibrations.add(line);
            }
            reader.close();
            return calibrations;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}