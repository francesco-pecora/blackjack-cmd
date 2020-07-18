package players.strategies;

import constants.Constants;
import players.Dealer;

public class HitOn17 implements DealerStrategy {
	
	Dealer dealer;
	
	public HitOn17(Dealer dealer) {
		setDealer(dealer);
	}
	
	@Override
	public void hit() {
		dealer.dealerGetsNewCard();
		if (dealer.getHand().calculateValue() > Constants.DEALER_STANDS_ON) {
			dealer.setStand(true);
		}
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
