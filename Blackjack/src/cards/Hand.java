package cards;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;
	private boolean isSplit;
	private boolean hasAce;
	
	public Hand() {
		hand = new ArrayList<Card>();
		isSplit = false;
		hasAce = false;
	}
	
	public Hand(ArrayList<Card> h, boolean isS) {
		hand = h;
		isSplit = isS;
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
		if (!isFirstRound() || isSplit) return false;
		else {
			String firstCardName = hand.get(0).getName();
			String secondCardName = hand.get(1).getName();
			if (firstCardName.equals(secondCardName)) {
				return true;
			}
			return false;
		}
	}

	
	/**
	 * function that returns whether the player is restricted to stand (because reached 21).
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
	 * function that returns whether the hand is a blackjack or not.
	 * 
	 * @return boolean
	 */
	public boolean isBlackJack() {
		if (isSplit) return false;
		else {
			Card firstCard = hand.get(0);
			Card secondCard = hand.get(1);
			
			// handling the case in which the second card is the 10
			boolean isFirstCardAce = firstCard.getName().equals("A");
			boolean isSecondCardTen = secondCard.getName().equals("10");
			if (isFirstCardAce && isSecondCardTen) {
				return true;
			}
			
			// handling case in which the first card is the 10
			boolean isSecondCardAce = secondCard.getName().equals("A");
			boolean isFirstCardTen = firstCard.getName().equals("10");
			if (isSecondCardAce && isFirstCardTen) {
				return true;
			}
			
			return false;
		}
	}
	
	public boolean canDoubleDown() {
		if (hand.size() == 2) return true;
		return false;
	}
	
	
	/**
	 * function that returns whether the players are playing the first round or not.
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isFirstRound() {
		if (hand.size() == 2 && !isSplit) return true;
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
			// if the new Ace make the hand bust, we give the Ace a value of 1
			if (card.getName().equals("A") && (totalValue + 11) > 21) {
				card.setValue(1);
			}
			// if we have a Ace that doesn't bust, we track it
			else if (card.getName().equals("A")) hasAce = true;
			totalValue += card.getValue();
		}
		// if we track an Ace and we didn't change its value, and 
		// we still bust, then we decrease the value by 10
		if (hasAce && totalValue > 21) totalValue -= 10;
		
		return totalValue;
	}
	
	
	/**
	 * function that adds a new card to the hand.
	 * 
	 * @param card : Card
	 */
	public void addCard(Card card) {
		if (card.equals(null)) return;
		if (card.getName().equals("A")) hasAce = true;
		hand.add(card);
	}
	
	public void removeCard(int index) {
		if (index < hand.size()) hand.remove(index);
	}

	public boolean isSplit() {
		return isSplit;
	}

	public void setIsSplit(boolean isSplit) {
		this.isSplit = isSplit;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		String s = "";
		for (Card card : hand) {
			s += "[" + card.getName() + "] ";
		}
		s += " = " + calculateValue(); 
		return s;
	}
	
}
