package dayTwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

        for(String line: lines) {
            isGamePossiblePartOne(line);
            isGamePossiblePartTwo(line);
        }

        System.out.println(idSum);

        for(int[] arr: powerList) {
            int mult = 1;
            for(int i: arr) {
                mult *= i;
            }
            sumofPowers += mult;
        }

        System.out.println(sumofPowers);
    }

    public static void isGamePossiblePartTwo(String str) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(":")));

        ArrayList<String> semicolonList = new ArrayList<>(Arrays.asList(list.get(1).split(";")));

        int minReds = Integer.MIN_VALUE;
        int minGreens = Integer.MIN_VALUE;
        int minBlues = Integer.MIN_VALUE;

        for(String s: semicolonList) {
            ArrayList<String> commaList = new ArrayList<>(Arrays.asList(s.split(",")));
            commaList.replaceAll(str1 -> str1.replaceAll("\\s+", ""));
            for(String s1: commaList) {
                if(s1.contains("red")) {
                    minReds = Math.max(minReds, Integer.parseInt(s1.substring(0, s1.indexOf("red"))));
                }
                if(s1.contains("green")) {
                    minGreens = Math.max(minGreens, Integer.parseInt(s1.substring(0, s1.indexOf("green"))));
                }
                if(s1.contains("blue")) {
                    minBlues = Math.max(minBlues, Integer.parseInt(s1.substring(0, s1.indexOf("blue"))));
                }
            }
        }

        // System.out.println("min reds: " + minReds + " min greens: " + minGreens + " min blues: " + minBlues);

        powerList.add(new int[]{minReds, minGreens, minBlues});
    }

    // 12 red cubes, 13 green cubes, 14 blue cubes
    public static void isGamePossiblePartOne(String str) {
        int gameId;

        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(":")));

        gameId = Integer.parseInt(list.get(0).substring(5));

        ArrayList<String> semicolonList = new ArrayList<>(Arrays.asList(list.get(1).split(";")));
        ArrayList<String> commaList = new ArrayList<>();
        for(String s : semicolonList) {
            commaList.addAll(Arrays.asList(s.split(",")));
        }

        int reds = 0;
        int greens = 0;
        int blues = 0;
        boolean isPossible = true;

        for(String s: commaList) {
            if(s.contains("red") && Integer.parseInt(s.substring(1, s.indexOf("red") - 1)) > 12) {
                isPossible = false;
                break;
            }
            if(s.contains("green") && Integer.parseInt(s.substring(1, s.indexOf("green") - 1)) > 13) {
                isPossible = false;
                break;
            }
            if(s.contains("blue") && Integer.parseInt(s.substring(1, s.indexOf("blue") - 1)) > 14) {
                isPossible = false;
                break;
            }
        }

        if(isPossible) {
            idSum += gameId;
        }
    }
}
