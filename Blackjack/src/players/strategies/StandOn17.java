package players.strategies;

import constants.Constants;
import players.Dealer;

public class StandOn17 implements DealerStrategy {
	
	
	// CLASS ATTRIBUTES
	
	Dealer dealer;
	
	
	// CLASS CONSTRUCTOR
	
	public StandOn17(Dealer dealer) {
		setDealer(dealer);
	}
	
	
	// CLASS METHODS
	
	/**
	 * function that allows the dealer to hit and get a new card
	 */
	@Override
	public void hit() {
		if (dealer.getHand().calculateValue() >= Constants.DEALER_STANDS_ON) {
			System.out.print("Dealer stands");
			dealer.setStand(true);
			return;
		}
		System.out.print("Dealer hits");
		dealer.dealerGetsNewCard();
	}
	
	
	/**
	 * function that allows the dealer to stand
	 */
	@Override
	public void stand() {
		dealer.setStand(true);
	}
	
	
	// GETTERS AND SETTERS

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
}
