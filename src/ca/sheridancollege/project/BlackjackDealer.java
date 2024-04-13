package ca.sheridancollege.project;

/**
 *
 * @author Alpha Warriors
 * @author Mayhansh, Rajat, Gurmanjot, Ashmeet
 */

 
public class BlackjackDealer extends Player {

    private GroupOfCards hand;

    public BlackjackDealer(String name) {
        super(name);
        hand = new GroupOfCards(52);
    }

    @Override
    public void play() {
        
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandAmount() {
        int amount = 0;
        int aceCount = 0;
        for (Card card : hand.getCards()) {
            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
            amount += Math.min(10, card.getRank().ordinal() + 1);
        }
        while (amount > 21 && aceCount > 0) {
            amount -= 10;
            aceCount--;
        }
        return amount;
    }
}
