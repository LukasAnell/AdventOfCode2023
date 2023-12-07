package daySeven;


import java.util.*;

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
        List<String> lines = Reader.readFromFile();
        assert lines != null;

        partOne(lines);
    }

    public static void partOne(List<String> lines) {
        Map<String, Integer> handToStrengthMap = new HashMap<>();


        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] splitLine = line.split(" ");
            String hand = splitLine[0];
            String bid = splitLine[1];

            int handStrength = findHandStrength(hand);
            handToStrengthMap.put(hand, handStrength);
        }

        List<String[]> sameStrengthHands = checkSameStrength(handToStrengthMap);

        for(int i = 0; i < sameStrengthHands.size() - 1; i++) {
            String[] hands = sameStrengthHands.get(i);
            String hand1 = hands[0];
            String hand2 = hands[1];
            String winner = compareHands(hand1, hand2);
            if(!winner.isEmpty()) {
                handToStrengthMap.put(winner, handToStrengthMap.get(winner) + 1);
                handToStrengthMap.put(winner.equals(hand1) ? hand2 : hand1, handToStrengthMap.get(winner.equals(hand1) ? hand2 : hand1) - 1);
            }
        }
    }

    public static String compareHands(String hand1, String hand2) {
        List<Integer> cards1 = new ArrayList<>();
        for (char c : hand1.toCharArray()) {
            cards1.add(handMap.get(String.valueOf(c)));
        }
        cards1.sort(Collections.reverseOrder());

        List<Integer> cards2 = new ArrayList<>();
        for (char c : hand2.toCharArray()) {
            cards2.add(handMap.get(String.valueOf(c)));
        }
        cards2.sort(Collections.reverseOrder());

        for (int i = 0; i < cards1.size(); i++) {
            if (cards1.get(i) > cards2.get(i)) {
                return hand1;
            } else if (cards1.get(i) < cards2.get(i)) {
                return hand2;
            }
        }

        return "";
    }

    public static List<String[]> checkSameStrength(Map<String, Integer> handToStrengthMap) {
        List<String[]> sameStrengthHands = new ArrayList<>();

        for(Map.Entry<String, Integer> entry1: handToStrengthMap.entrySet()) {
            for(Map.Entry<String, Integer> entry2: handToStrengthMap.entrySet()) {
                if(!entry1.getKey().equals(entry2.getKey()) && entry1.getValue().equals(entry2.getValue())) {
                    sameStrengthHands.add(new String[]{entry1.getKey(), entry2.getKey()});
                }
            }
        }
        return sameStrengthHands;
    }

    public static int findHandStrength(String hand) {
        String[] splitHand = hand.split("");
        int handStrength = 0;
        for(String card: splitHand) {
            if(handMap.containsKey(card)) {
                handStrength += handMap.get(card);
            }
        }
        return handStrength;
    }
}
