package players;

import cards.Hand;

public abstract class BlackJackPlayer {

	protected Hand hand;
	protected Hand splitHand;
	protected boolean stand;
	
	public BlackJackPlayer() {
		setHand(new Hand());
		setSplitHand(new Hand());
		setStand(false);
	}

	public abstract void play(Hand hand, Dealer dealer);
	
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