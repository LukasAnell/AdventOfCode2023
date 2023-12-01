import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.stream.Stream;

public class AdventOfCodeDay1 {
    public static int sum = 0;
    public static Dictionary<String, Integer> dict = new Hashtable<>();
    public static void main(String[] args) {
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);
        dict.put("five", 5);
        dict.put("six", 6);
        dict.put("seven", 7);
        dict.put("eight", 8);
        dict.put("nine", 9);

        Path path = Paths.get("/Users/per2/IdeaProjects/AdventOfCode/src/Day1Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AdventOfCodeDay1::findRealFirstLastNums);
        } catch (IOException e) {
            //error happened
        }
        System.out.println(sum);
    }

    public static void findRealFirstLastNums(String str) {
        String number = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.startsWith("one", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("two", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("three", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("four", i)) {
                number += dict.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("five", i)) {
                number += dict.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("six", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("seven", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("eight", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("nine", i)) {
                number += dict.get(str.substring(i, i + 4));
                break;
            }

            if(Character.isDigit(str.charAt(i))) {
                number += Character.getNumericValue(str.charAt(i));
                break;
            }
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.startsWith("one", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("two", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("three", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("four", i)) {
                number += dict.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("five", i)) {
                number += dict.get(str.substring(i, i + 4));
                break;
            }
            if(str.startsWith("six", i)) {
                number += dict.get(str.substring(i, i + 3));
                break;
            }
            if(str.startsWith("seven", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("eight", i)) {
                number += dict.get(str.substring(i, i + 5));
                break;
            }
            if(str.startsWith("nine", i)) {
                number += dict.get(str.substring(i, i + 4));
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
