package dayFour;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AoC4 {
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static List<Integer> numberList = new ArrayList<>();
    public static List<Card> allCards3 = new ArrayList<>();
    public static List<Card> allCards2 = new ArrayList<>();
    public static List<Card> allCards = new ArrayList<>();
    public static int numScratchCards = 0;
    public static int sum = 0;

    public static void main(String[] args) {
        Path path = Paths.get("src/dayFour/Day4Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC4::processLines);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }
        System.out.println(sum);

        partTwo();
        System.out.println(numScratchCards);
        // 15312 too low
    }

    public static void processLines(String str) {
        List<Integer> winningNumbers = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        splitLists(winningNumbers, numberList, str);

        allCards.add(new Card(Integer.parseInt(List.of(str.split(":")).get(0).replaceAll("\\s", "").substring(4)), winningNumbers, numberList));

        // int cardId = Integer.parseInt(List.of(str.split(":")).get(0).replaceAll("\\s", "").substring(4));

        // int numWinningNumbers = searchForWinningNumbers(winningNumbers, numberList);
    }

    public static void partTwo() {
        for (int i = 0; i < allCards.size() - 1; i++) {
            Card card = allCards.get(i);
            int numWinningNumbers = searchForWinningNumbers(card.getWinningNumbers(), card.getNumberList());
            for(int j = 0; j < numWinningNumbers; j++) {
                allCards2.add(new Card(card.getCardId() + j, allCards.get(i + j).getWinningNumbers(), allCards.get(i + j).getNumberList()));
            }
        }

        for(int i = 0; i < allCards2.size() - 1; i++) {
            Card card = allCards2.get(i);
            int numWinningNumbers = searchForWinningNumbers(card.getWinningNumbers(), card.getNumberList());
            for(int j = 0; j < numWinningNumbers; j++) {
                allCards3.add(new Card(card.getCardId() + j, allCards2.get(i + j).getWinningNumbers(), allCards2.get(i + j).getNumberList()));
            }
        }

        for(Card ownedCard: allCards) {
            numScratchCards++;
        }

        for (Card ownedCard : allCards2) {
            numScratchCards++;
        }

        for (Card ownedCard : allCards3) {
            numScratchCards++;
        }
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
