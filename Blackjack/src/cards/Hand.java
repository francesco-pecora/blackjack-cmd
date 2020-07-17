package cards;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * function that return whether the player has a loosing hand.
	 * 
	 * @return boolean
	 */
	public boolean isBust() {
		int handValue = calculateValue();
		if (handValue > 21) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns whether the hand can be split in two hands.
	 * 
	 * @return boolean
	 */
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

	/**
	 * function that returns whether the player is restricted to stand
	 * 
	 * @return boolean
	 */
	public boolean isRestricted() {
		int handValue = calculateValue();
		if (handValue == 21) {
			return true;
		}
		return false;
	}
	
	/**
	 * function that returns whether the players are playing the first round or not
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isFirstRound() {
		if (hand.size() == 2) return true;
		return false;
	}
	
	/**
	 * function that calculates the total value of a hand.
	 * 
	 * @return totalValue : int
	 */
	public int calculateValue() {
		int totalValue = 0;
		for (Card card : hand) {
			totalValue += card.getValue();
		}
		return totalValue;
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
