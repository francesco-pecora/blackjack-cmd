package cards;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public boolean isSplittable() {
		if (!isFirstRound()) return false;
		else {
			Card firstCard = hand.get(0);
			Card secondCard = hand.get(1);
			if (firstCard.equals(secondCard)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public boolean isRestricted() {
		return true;
	}
	
	public boolean isFirstRound() {
		if (hand.size() == 2) return true;
		return false;
	}
	
	public int calculateValue() {
		return 1;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
}
