package daySeven;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import Utils.Reader;

public class AoC7 {
    public static Map<String, Integer> handMap = new HashMap<>() {{
        put("A", 14);
        put("K", 13);
        put("Q", 12);
        put("J", 11);
        put("T", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};
    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/daySeven/Day7Input.txt");
        assert lines != null;

        partOne(lines);
        // 251290417 too low
        // 253341391 too high
    }

    public static void partOne(List<String> lines) {
        List<String> handList = new ArrayList<>();
        Map<String, Integer> handToBidMap = new HashMap<>();

        for(String line: lines) {
            String hand = line.split(" ")[0];
            int bid = Integer.parseInt(line.split(" ")[1]);
            handToBidMap.put(hand, bid);
            handList.add(hand);
        }

        for(int i = 0; i < handList.size(); i++) {
            handList.sort(Comparator.comparingInt(AoC7::findHandType));
        }
        for(int i = 0; i < handList.size() / 2; i++) {
            sortHandsByCards(handList);
        }

        int sum = 0;
        System.out.println(handList);
        for(int i = 0; i < handList.size(); i++) {
            String hand = handList.get(i);
            sum += handToBidMap.get(hand) * (i + 1);
        }
        System.out.println(sum);
    }

    public static void sortHandsByCards(List<String> handList) {
        for(int i = 0; i < handList.size() - 1; i++) {
            String hand1 = handList.get(i);
            String hand2 = handList.get(i + 1);
            if(findHandType(hand1) == findHandType(hand2)) {
                for(int j = 0; j < hand1.length(); j++) {
                    if(hand1.charAt(j) != hand2.charAt(j)) {
                        int hand1Card = handMap.get(hand1.substring(j, j + 1));
                        int hand2Card = handMap.get(hand2.substring(j, j + 1));

                        if(hand1Card > hand2Card) {
                            handList.set(i + 1, hand1);
                            handList.set(i, hand2);
                        }
                        break;
                    }
                }
            }
        }
    }

    public static int findHandType(String hand) {
        Map<Character, Integer> frequency =
                hand.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));

        return Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getValue();
    }
}
