package dayOne;

import java.util.*;

import Utils.Reader;

public class AoC1 {
    public static Map<String, Integer> numStringToInt = new HashMap<>() {{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
    }};
    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/dayOne/Day1Input.txt");
        assert lines != null;

        partOne(lines);
        partTwo(lines);
    }

    public static void partTwo(List<String> lines) {
        int sum = 0;
        for(String line: lines) {
            for(String num: numStringToInt.keySet()) {
                line = line.replace(num, num.substring(0, num.length() / 2) + numStringToInt.get(num) + num.substring(num.length() / 2 + 1));
            }
            sum += findFirstLastNums(line);
        }
        System.out.println(sum);
    }

    public static void partOne(List<String> lines) {
        int sum = 0;
        for(String line: lines) {
            sum += findFirstLastNums(line);
        }
        System.out.println(sum);
    }

    public static int findFirstLastNums(String line) {
        String[] nums = Arrays.stream(line.split(""))
                .filter(s -> s.matches("[0-9]"))
                .toArray(String[]::new);
        return Integer.parseInt(nums[0] + nums[nums.length - 1]);
    }
}
