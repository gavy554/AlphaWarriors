package ca.sheridancollege.project;

import java.util.ArrayList;

public class BlackjackPlayer extends Player {

    private GroupOfCards hand;

    public BlackjackPlayer(String name) {
        super(name);
        hand = new GroupOfCards(52);
    }

    @Override
    public void play() {
        // Player's logic can be implemented here if needed
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;
        for (Card card : hand.getCards()) {
            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
            value += Math.min(10, card.getRank().ordinal() + 1);
        }
//        while (value > 21 && aceCount > 0) {
//            value -= 10;
//            aceCount--;
//        }
        return value;
    }

    public String getLatestCard() {
        return hand.getCards().get(hand.getCards().size() - 1).toString();
    }

    public boolean isBusted() {
        return getHandValue() > 21;
    }
}
