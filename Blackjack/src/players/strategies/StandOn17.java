package players.strategies;

import constants.Constants;
import players.Dealer;

public class StandOn17 {
	
	Dealer dealer;
	
	public StandOn17(Dealer dealer) {
		setDealer(dealer);
	}
	
	public void hit() {
		dealer.dealerGetsNewCard();
		if (dealer.getHand().calculateValue() >= Constants.DEALER_STANDS_ON) {
			dealer.setStand(true);
		}
	}
	
	public void stand() {
		dealer.setStand(true);
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
}
