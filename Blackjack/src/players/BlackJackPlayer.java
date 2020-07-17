package players;

import cards.Hand;

public abstract class BlackJackPlayer {

	private Hand hand;
	
	public BlackJackPlayer() {
		hand = new Hand();
	}
	
	public abstract void hit();
	
	public abstract void stand();

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}