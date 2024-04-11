package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards;
    private int size;// the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        } else {
            System.out.println("Cannot add more cards. The group is full.");
        }
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null; // Handle deck being empty
        }
    }
}
