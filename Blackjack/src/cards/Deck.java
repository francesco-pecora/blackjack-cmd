package cards;

import java.util.ArrayList;

import constants.Constants;

public class Deck {

	
	// CLASS ATTRIBUTES
	
	private ArrayList<Card> cards;

	
	// CLASS CONSTRUCTORS
	
	public Deck() {
		cards = new ArrayList<Card>();
		initializeDeck();
	}
	
	
	// CLASS METHODS
	
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
					// int index = (52 * k) + (13 * i) + (j - 1);

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
					else {
						System.out.println("[Error] Should not enter this else statement.");
					}
					cards.add(currentCard);
				}
			}
		}
	}
	
	
	/**
	 * function that returns and removes the top Card of the deck of cards
	 * 
	 * @return Card
	 */
	public Card pop() {
		int lastIndex = cards.size() - 1;
		Card toReturn = cards.get(lastIndex);
		cards.remove(lastIndex);
		return toReturn;
	}
	
	
	// SETTERS AND GETTERS
	
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
}
