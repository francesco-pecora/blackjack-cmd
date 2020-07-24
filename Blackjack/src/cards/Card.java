package cards;

import java.util.ArrayList;

public class Card {

	
	// CLASS ATTRIBUTES
	
	private String name;
	private int value;
	
	
	// CLASS CONSTRUCTORS
	
	public Card(String n, int v) {
		setName(n);
		setValue(v);
	}

	
	public int calculateValueIntoHand(Hand hand) {
		if (name.equals("J") || name.equals("Q") || name.equals("K")) {
			return 10;
		}
		
		if (name.equals("A")) {
			ArrayList<Card> currentCards = hand.getHand();
			Card firstAceInHand = null;
			int totalValue = 0;
			
			
			for (Card card : currentCards) {
				if (card.getName().equals("A")) {
					firstAceInHand = card;
					break;
				}
			}
			
			if (this == firstAceInHand) {
				for (Card card : currentCards) {
					if (card == firstAceInHand) {
						continue;
					}
					totalValue += card.getValue();
				}
				if (totalValue + 11 <= 21) return 11;
				return 1;
			}
			else {
				return 1;
			}
		}
		
		return value;
	}
	
	
	// GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
}
