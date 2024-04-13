package ca.sheridancollege.project;

import java.util.Scanner;
/**
 *
 * @author Alpha Warriors
 * @author Mayhansh, Rajat, Gurmanjot, Ashmeet
 */

public class BlackjackGame extends Game {

    private GroupOfCards deck;
    private BlackjackDealer dealer;
    private BlackjackPlayer player;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        initializeDeck();
        dealer = new BlackjackDealer("Dealer");
        player = new BlackjackPlayer("Player");
    }

    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.addCard(new Card(rank, suit));
            }
        }
        deck.shuffle();
    }

    @Override
    public void play() 
    {
        dealInitialCards();

        playerTurn();

        dealerTurn();

        String res = declareWinner();
        System.out.println(res);
    }

    public void dealInitialCards() {
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your hand: " + player.getHandAmount());
            System.out.println("Do you want to hit or stand? (h/s)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCard(deck.dealCard());
                System.out.println("You drew: " + player.getLatestCard());
                if (player.isBusted()) {
                    System.out.println("Busted! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public void dealerTurn() {
        while (dealer.getHandAmount() < 17) {
            dealer.addCard(deck.dealCard());
        }
        System.out.println("Dealer's hand: " + dealer.getHandAmount());
    }

    @Override
    public String declareWinner() {
        int playerScore = player.getHandAmount();
        int dealerScore = dealer.getHandAmount();

        if (playerScore > 21) {
            return "Player busted. Dealer wins!";
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            return "Player wins!";
        } else if (playerScore == dealerScore) {
            return "It's a tie!";
        } else {
            return "Dealer wins!";
        }
    }

    public static void main(String[] args) {
        BlackjackGame blackjack = new BlackjackGame("Blackjack");
        blackjack.play();
    }

    public Object getDeck() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDealer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
