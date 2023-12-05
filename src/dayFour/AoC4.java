package dayFour;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AoC4 {
    public static List<String> input = new ArrayList<>();
    public static List<Integer> cardAmounts = new ArrayList<>();
    public static int numScratchCards = 0;
    public static int sum = 0;

    public static void main(String[] args) {
        Path path = Paths.get("src/dayFour/Day4Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC4::partOne);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }
        path = Paths.get("src/dayFour/Day4Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC4::processLines);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }

        System.out.println(sum);

        partTwo();
        System.out.println(numScratchCards);
        // 8467762 answer!
    }

    public static void processLines(String str) {
        input.add(str);
    }

    public static void partTwo() {
        for(int i = 0; i < input.size(); i++) {
            cardAmounts.add(1);
        }

        for(int i = 0; i < input.size(); i++) {
            List<Integer> winningNumbers = new ArrayList<>();
            String[] winningNumbersArray = input.get(i).split("\\|")[0].split(":")[1].split(" ");
            for (String s : winningNumbersArray) {
                if (!s.equals(" ") && !s.isEmpty()) {
                    winningNumbers.add(Integer.valueOf(s));
                }
            }

            List<Integer> numberList = new ArrayList<>();
            String[] numberListArray = input.get(i).split("\\|")[1].split(" ");
            for (String s : numberListArray) {
                if (!s.equals(" ") && !s.isEmpty()) {
                    numberList.add(Integer.valueOf(s));
                }
            }

            int wins = 0;

            for(Integer number: numberList) {
                if(winningNumbers.contains(number)) {
                    wins++;
                }
            }

            for(int j = 0; j < cardAmounts.get(i); j++) {
                int a = 1;
                for(int k = 0; k < wins; k++) {
                    cardAmounts.set(i + a, cardAmounts.get(i + a) + 1);
                    a++;
                }
            }
        }

        int sumIds = 0;

        for(Integer cardAmount: cardAmounts) {
            sumIds += cardAmount;
        }

        numScratchCards = sumIds;
    }

    public static void partOne(String str) {
        List<Integer> winningNumbers = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        splitLists(winningNumbers, numberList, str);

        int numWinningNumbers = searchForWinningNumbers(winningNumbers, numberList);

        int pointValue = 0;

        if(numWinningNumbers >= 1) {
            pointValue++;
            for(int i = 0; i < numWinningNumbers - 1; i++) {
                pointValue *= 2;
            }
        }

        sum += pointValue;
    }

    private static void splitLists(List<Integer> winningNumbers, List<Integer> numberList, String str) {
        List<String> splitString = List.of(str.split("\\|"));
        List<String> splitString2 = List.of(List.of(splitString.get(0).split(":")).get(1).split(" "));
        List<String> splitString3 = List.of(splitString.get(1).split(" "));

        for (String s : splitString2) {
            if (!s.equals(" ") && !s.isEmpty()) {
                winningNumbers.add(Integer.valueOf(s));
            }
        }

        for (String s : splitString3) {
            if (!s.equals(" ") && !s.isEmpty()) {
                numberList.add(Integer.valueOf(s));
            }
        }
    }

    public static int searchForWinningNumbers(List<Integer> winningNumbers, List<Integer> numberList) {
        int numWinningNumbers = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numberList.contains(winningNumber)) {
                numWinningNumbers++;
            }
        }
        return numWinningNumbers;
    }
}
