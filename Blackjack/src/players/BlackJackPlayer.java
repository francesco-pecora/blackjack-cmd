package players;

import cards.Hand;

public abstract class BlackJackPlayer {

	
	// CLASS ATTRIBUTES
	
	protected Hand hand;
	protected Hand splitHand;
	protected boolean stand;
	
	
	// CONSTRUCTORS
	
	public BlackJackPlayer() {
		setHand(new Hand());
		setSplitHand(new Hand());
		setStand(false);
	}

	
	// CLASS METHODS
	
	/**
	 * abstract function that allows the blackjack player to play a hand
	 * 
	 * @param hand : Hand
	 * @param dealer : Dealer
	 */
	public abstract void play(Hand hand, Dealer dealer);
	
	
	/**
	 * function that outputs the information about the hand
	 * 
	 * @param hand : Hand
	 */
	public void printGameInfo(Hand hand) {
		System.out.println(hand);
	}
	
	
	// SETTERS AND GETTERS
	
	public boolean isStand() {
		return stand;
	}

	public void setStand(boolean stand) {
		this.stand = stand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Hand getSplitHand() {
		return splitHand;
	}

	public void setSplitHand(Hand splitHand) {
		this.splitHand = splitHand;
	}
}