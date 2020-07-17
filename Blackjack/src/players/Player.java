package players;

public class Player extends BlackJackPlayer{

	private int funds;
	private int bet;
	
	public Player(int f) {
		super();
		setFunds(f);
		setBet(0);
	}
	
	public void hit() {
		
	}
	
	public void stand() {
		
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
	
}
