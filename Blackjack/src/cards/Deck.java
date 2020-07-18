package cards;

import java.util.ArrayList;

import constants.Constants;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		initializeDeck();
	}
	
	/**
	 * function that initializes the decks of 52 cards each, giving each Card a name
	 * and a value following the rules of BlackJack
	 */
	private void initializeDeck() {
		
		// outside loop to initialize more than one deck
		for (int k = 0; k < Constants.NUM_OF_DECKS; k++) {
		
			// inner loops initialize one deck
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < 14; j++) {
					
					// need the minus 1 because j starts from 1
					//      - first member increases the index for each different deck
					//		- second member increases the index for each suit
					//		- third member increases the index for each number in one straight
					//int index = (52 * k) + (13 * i) + (j - 1);

					Card currentCard = new Card("", 0);
					if (j == 1) {
						currentCard = new Card("A", 11);
					}
					else if (j > 1 && j < 11) {
						currentCard = new Card(String.valueOf(j), j);
					}
					else if (j == 11){
						currentCard = new Card("J", 10);
					}
					else if (j == 12) {
						currentCard = new Card("Q", 10);
					}
					else if (j == 13) {
						currentCard = new Card("K", 10);
					}
					cards.add(currentCard);
				}
			}
			
		}
	}
	
	public Card pop() {
		Card toReturn = cards.get(0);
		cards.remove(0);
		return toReturn;
	}
	
	/**
	 * function that returns the whole list of cards
	 * 
	 * @return cards : Card[]
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * custom output for the Deck of cards
	 */
	@Override
	public String toString() {
		String s = "";
		for (Card card : cards) {
			s += card.getName();
			s += "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck);
		System.out.println(deck.cards.size());
	}
	
}
