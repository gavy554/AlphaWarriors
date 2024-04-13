/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class TestBlackjackGame {
    
    @Test
    public void testPlayerBusted() {
        BlackjackGame game = new BlackjackGame("Test Blackjack");
        game.dealInitialCards();

        BlackjackPlayer player = (BlackjackPlayer) game.getPlayer();
        player.addCard(new Card(Card.Rank.TEN, Card.Suit.Spades));
        player.addCard(new Card(Card.Rank.SEVEN, Card.Suit.Clubs));
        player.addCard(new Card(Card.Rank.FIVE, Card.Suit.Hearts));

        assertTrue(player.isBusted());
    }
    
    @Test
    public void testDealerBusted() {
        BlackjackGame game = new BlackjackGame("Test Blackjack");
        game.dealInitialCards();

        BlackjackDealer dealer = (BlackjackDealer) game.getDealer();
        dealer.addCard(new Card(Card.Rank.TEN, Card.Suit.Spades));
        dealer.addCard(new Card(Card.Rank.SEVEN, Card.Suit.Clubs));
        dealer.addCard(new Card(Card.Rank.FIVE, Card.Suit.Hearts));

        assertTrue(dealer.getHandAmount() > 21);
    }
    
    @Test
    public void testDeclareWinnerPlayerWins() {
        BlackjackGame game = new BlackjackGame("Test Blackjack");
        BlackjackPlayer player = (BlackjackPlayer) game.getPlayer();
        BlackjackDealer dealer = (BlackjackDealer) game.getDealer();

        player.addCard(new Card(Card.Rank.TEN, Card.Suit.Spades));
        player.addCard(new Card(Card.Rank.SEVEN, Card.Suit.Clubs));
        dealer.addCard(new Card(Card.Rank.TEN, Card.Suit.Hearts));
        dealer.addCard(new Card(Card.Rank.FIVE, Card.Suit.Diamonds));

        assertTrue(game.declareWinner().contains("Player wins!"));
    }
        
    @Test
    public void testDeclareWinnerDealerWins() {
        BlackjackGame game = new BlackjackGame("Test Blackjack");
        BlackjackPlayer player = (BlackjackPlayer) game.getPlayer();
        BlackjackDealer dealer = (BlackjackDealer) game.getDealer();

        player.addCard(new Card(Card.Rank.SEVEN, Card.Suit.Clubs));
        dealer.addCard(new Card(Card.Rank.TEN, Card.Suit.Hearts));
        dealer.addCard(new Card(Card.Rank.SEVEN, Card.Suit.Spades));

        assertEquals("Dealer wins!", game.declareWinner());
    }
    
}
