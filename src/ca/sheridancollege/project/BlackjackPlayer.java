package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Alpha Warriors
 * @author Mayhansh, Rajat, Gurmanjot, Ashmeet
 */

public class BlackjackPlayer extends Player {

    private GroupOfCards hand;

    public BlackjackPlayer(String name) {
        super(name);
        hand = new GroupOfCards(52);
    }

    public void getCard()
    {
        
    }
    
    @Override
    public void play() {
        // Player's logic
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandAmount() {
        int value = 0;
        int aceCount = 0;
        for (Card card : hand.getCards()) {
            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
            value += Math.min(10, card.getRank().ordinal() + 1);
        }
        return value;
    }

    public String getLatestCard() {
        return hand.getCards().get(hand.getCards().size() - 1).toString();
    }

    public boolean isBusted() {
        return getHandAmount() > 21;
    }
}
