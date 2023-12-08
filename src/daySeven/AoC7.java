package daySeven;


import java.util.*;

import Utils.Reader;

public class AoC7 {
    public static Map<String, Integer> partOneHandMap = new HashMap<>() {{
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

    public static Map<String, Integer> partTwoHandMap = new HashMap<>() {{
        put("A", 14);
        put("K", 13);
        put("Q", 12);
        put("T", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
        put("J", 1);
    }};

    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/daySeven/Day7Input.txt");
        assert lines != null;

        partOne(lines);
        // 252656917 answer
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

        handList.sort(Comparator.comparingInt(AoC7::findHandType));
        for(int i = 0; i < handList.size() / 2; i++) {
            sortHandsByCards(handList);
        }

        int sum = 0;
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
                        int hand1Card = partOneHandMap.get(Character.toString(hand1.charAt(j)));
                        int hand2Card = partOneHandMap.get(Character.toString(hand2.charAt(j)));

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
        Map<Character, Integer> frequency = hand.chars()
            .mapToObj(i -> (char) i)
            .collect(HashMap::new, (m, k) -> m.merge(k, 1, Integer::sum), Map::putAll);

        if(frequency.size() == 1 && frequency.containsValue(5)) {
            return 7;
        }
        if(frequency.size() == 2 && frequency.containsValue(4)) {
            return 6;
        }
        if(frequency.containsValue(3) && frequency.containsValue(2)) {
            return 5;
        }
        if(frequency.size() == 3 && frequency.containsValue(3)) {
            return 4;
        }
        if(frequency.size() == 3 && Collections.frequency(frequency.values(), 2) == 2) {
            return 3;
        }
        if(frequency.size() == 4 && frequency.containsValue(2)) {
            return 2;
        }
        if(frequency.size() == 5) {
            return 1;
        }
        return Collections.max(frequency.values());
    }
}
