package players;

import cards.Deck;

public class Dealer extends BlackJackPlayer{

	private Deck deck;
	
	public Dealer() {
		super();
		deck = new Deck();
	}
	
	public void shuffle() {
		
	}
	
	public void handCardToPlayer(Player player) {
		
	}
	
	public void dealerGetsNewCard() {
		
	}
	
	public void hit() {
		
	}
	
	public void stand() {
		
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
