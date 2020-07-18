package players.strategies;

import constants.Constants;
import players.Dealer;

public class StandOn17 implements DealerStrategy {
	
	Dealer dealer;
	
	public StandOn17(Dealer dealer) {
		setDealer(dealer);
	}
	
	@Override
	public void hit() {
		if (dealer.getHand().calculateValue() >= Constants.DEALER_STANDS_ON) {
			dealer.setStand(true);
			return;
		}
		dealer.dealerGetsNewCard();
	}
	
	@Override
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
