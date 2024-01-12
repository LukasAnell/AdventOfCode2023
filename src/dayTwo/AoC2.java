package dayTwo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import Utils.Reader;

public class AoC2 {
    public static int idSum = 0;
    public static int sumofPowers = 0;
    public static ArrayList<int[]> powerList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/dayTwo/Day2Input.txt");
        assert lines != null;

        partOne(lines);
        partTwo(lines);
    }

    public static void partOne(List<String> lines) {
        int sum = 0;
        for(String line: lines) {
            int Id = Integer.parseInt(line.split(":")[0].split(" ")[1]);
            List<List<String[]>> games = Collections.singletonList(Stream.of(line.split(":")[1].split(";")).map(s -> s.stripLeading().split(", ")).toList());

            int maxRed = 12;
            int maxGreen = 13;
            int maxBlue = 14;

            for(List<String[]> game: games) {
                int red = 0;
                int green = 0;
                int blue = 0;
                for(String[] set: game) {
                    for(String cubes: set) {
                        String color = cubes.substring(cubes.indexOf(cubes.split(" ")[1]));
                        int amount = Integer.parseInt(cubes.split(" ")[0]);
                        switch(color) {
                            case "red":
                                red = Math.max(red, amount);
                            case "green":
                                green = Math.max(green, amount);
                            case "blue":
                                blue = Math.max(blue, amount);
                        }
                    }
                }
                if(red <= maxRed && green <= maxGreen && blue <= maxBlue) {
                    sum += Id;
                }
            }
        }
        System.out.println(sum);
    }

    public static void partTwo(List<String> lines) {
        int sum = 0;
        for(String line: lines) {
            List<List<String[]>> sets = Collections.singletonList(Stream.of(line.split(":")[1].split(";")).map(s -> s.stripLeading().split(", ")).toList());
            int red = 1;
            int green = 1;
            int blue = 1;
            for(List<String[]> element: sets) {
                for(String[] amountAndColor: element) {
                    for(String cubes: amountAndColor) {
                        String color = cubes.substring(cubes.indexOf(cubes.split(" ")[1]));
                        int amount = Integer.parseInt(cubes.split(" ")[0]);
                        switch(color) {
                            case "red":
                                red = Math.max(red, amount);
                                break;
                            case "green":
                                green = Math.max(green, amount);
                                break;
                            case "blue":
                                blue = Math.max(blue, amount);
                                break;
                        }
                    }
                }
            }
            sum += red * green * blue;
        }
        System.out.println(sum);
    }
}
