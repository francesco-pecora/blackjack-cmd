package players;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Deck;
import cards.Hand;
import players.strategies.StandOn17;

public class Dealer extends BlackJackPlayer{

	private Deck deck;
	private StandOn17 strategy;
	
	public Dealer() {
		super();
		deck = new Deck();
		strategy = new StandOn17(this);
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
	
	@Override
	public void play(Hand hand, Dealer dealer) {
		while (true) {
			if (stand) return;
			else strategy.hit();
		}
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
