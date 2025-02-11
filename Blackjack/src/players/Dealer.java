package players;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Deck;
import cards.Hand;
import players.strategies.StandOn17;

public class Dealer extends BlackJackPlayer{

	
	// CLASS ATTRIBUTES
	
	private Deck deck;
	private StandOn17 strategy;
	
	
	// CLASS CONSTRUCTORS
	
	public Dealer() {
		super();
		deck = new Deck();
		strategy = new StandOn17(this);
	}
	
	
	// CLASS METHODS
	
	/**
	 * main playing function that controls the order of actions.
	 */
	@Override
	public void play(Hand hand, Dealer dealer) {
		System.out.print("Dealer shows hand. ");
		while (true) {
			if (stand) return;
			printGameInfo(hand);
			if (hand.isBlackJack()) return;
			else strategy.hit();
		}
	}
	
	
	/**
	 * function that shuffles the deck of cards.
	 */
	public void shuffle() {
		ArrayList<Card> cards = deck.getCards();
		Collections.shuffle(cards);
	}
	
	
	/**
	 * function that hands a new card to the player.
	 * 
	 * @param player : Player
	 * @param hand : Hand
	 */
	public void handCardToPlayer(Hand hand) {
		Card cardToHand = deck.pop();
		hand.addCard(cardToHand);
	}
	
	
	/**
	 * function that adds a card to the hand of the dealer.
	 */
	public void dealerGetsNewCard() {
		Card cardForDealer = deck.pop();
		hand.addCard(cardForDealer);
	}
	
	
	/**
	 * toString-like function that displays the hand of the dealer with a hidden card
	 * 
	 * @return String
	 */
	public String displayWithHiddenCard() {
		
		Card toShow = hand.getHand().get(0);
		String s = "Dealer hand is " + toShow + " [-]";
		return s;
	}

	
	// GETTERS AND SETTERS
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
