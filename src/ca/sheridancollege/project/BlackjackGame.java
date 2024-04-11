package ca.sheridancollege.project;

import java.util.Scanner;

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
    public void play() {
        // Deal initial cards
        dealInitialCards();

        // Player's turn
        playerTurn();

        // Dealer's turn
        dealerTurn();

        // Declare winner
        declareWinner();
    }

    private void dealInitialCards() {
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your hand: " + player.getHandValue());
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

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addCard(deck.dealCard());
        }
        System.out.println("Dealer's hand: " + dealer.getHandValue());
    }

    @Override
    public void declareWinner() {
        int playerScore = player.getHandValue();
        int dealerScore = dealer.getHandValue();
        if (playerScore > 21) {
            System.out.println("Player busted. Dealer wins!");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
        } else if (playerScore == dealerScore) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins!");
        }
    }

    public static void main(String[] args) {
        BlackjackGame blackjack = new BlackjackGame("Blackjack");
        blackjack.play();
    }
}
