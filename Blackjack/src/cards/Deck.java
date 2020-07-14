package cards;

import java.util.Arrays;

public class Deck {

	private Card[] cards;

	public Deck() {
		cards = new Card[52];	// deck of 52 cards
		initializeDeck();
	}
	
	/**
	 * function that initializes the deck a deck of 52 cards, giving each Card a name
	 * and a value following the rules of BlackJack
	 */
	private void initializeDeck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < 14; j++) {
				
				// need the minus 1 because j starts from 1
				int index = (13 * i) + j - 1;
				
				if (j == 1) {
					cards[index] = new Card("A", 11);
				}
				else if (j > 1 && j < 11) {
					cards[index] = new Card(String.valueOf(j), j);
				}
				else if (j == 11){
					cards[index] = new Card("J", 10);
				}
				else if (j == 12) {
					cards[index] = new Card("Q", 10);
				}
				else if (j == 13) {
					cards[index] = new Card("K", 10);
				}
			}
		}
	}
	
	/**
	 * function that returns the whole list of cards
	 * 
	 * @return cards : Card[]
	 */
	public Card[] getCards() {
		return cards;
	}
	
	/**
	 * custom output for the Deck of cards
	 */
	@Override
	public String toString() {
		return "Deck [cards=" + Arrays.toString(cards) + "]";
	}
	
}
