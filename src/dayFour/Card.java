package dayFour;

import java.util.List;

public class Card {
    private int cardId;
    private List<Integer> winningNumbers;
    private List<Integer> numberList;

    public Card(int cId, List<Integer> wN, List<Integer> nL) {
        cardId = cId;
        winningNumbers = wN;
        numberList = nL;
    }

    public int getCardId() {
        return cardId;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
