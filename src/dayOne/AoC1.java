package dayOne;

import java.util.*;

import Utils.Reader;

public class AoC1 {
    public static int sum = 0;
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

        for (String line: lines) {
            findRealFirstLastNums(line);
        }
        System.out.println(sum);
    }

    public static void partOne(List<String> lines) {
        int sum = 0;
        for(String line: lines) {
            String[] nums = Arrays.stream(line.split(""))
                    .filter(s -> s.matches("[0-9]"))
                    .toArray(String[]::new);
            sum += Integer.parseInt(nums[0] + nums[nums.length - 1]);
        }
        System.out.println(sum);
    }

    public static void findRealFirstLastNums(String str) {
        String number = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.startsWith("one", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("two", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("three", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("four", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("five", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("six", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("seven", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("eight", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("nine", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }

            if(Character.isDigit(str.charAt(i))) {
                number += Character.getNumericValue(str.charAt(i));
                break;
            }
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.startsWith("one", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("two", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("three", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("four", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("five", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("six", i)) {
                number += numStringToInt.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("seven", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("eight", i)) {
                number += numStringToInt.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("nine", i)) {
                number += numStringToInt.get(str.substring(i, i + 4));
                break;
            }

            if(Character.isDigit(str.charAt(i))) {
                number += Character.getNumericValue(str.charAt(i));
                break;
            }
        }
        sum += Integer.parseInt(number);
    }

    public static void findFirstLastNums(String str) {
        String number = "";
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                number += Character.getNumericValue(str.charAt(i));
                break;
            }
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            if(Character.isDigit(str.charAt(i))) {
                number += Character.getNumericValue(str.charAt(i));
                break;
            }
        }
        sum += Integer.parseInt(number);
    }
}
