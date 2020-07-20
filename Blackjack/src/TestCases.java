import cards.Card;
import cards.Hand;
import players.Dealer;
import players.Player;

public class TestCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onlyPlayerHasBlackJack();
		
		System.out.println();
		System.out.println();
		
		playerAndDelaerHaveBlackJack();
		
		System.out.println();
		System.out.println();
		
		playerSplit();
	}
	
	
	/**
	 * function that simulates the situation where only the player has a blackjack
	 */
	public static void onlyPlayerHasBlackJack() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		player.placeBet(10);
		
		dealer.shuffle();
		
		Card firstCardPlayer = new Card("A", 11);
		Card secondCardPlayer = new Card("10", 10);
		
		Hand playerHand = player.getHand();
		playerHand.addCard(firstCardPlayer);
		playerHand.addCard(secondCardPlayer);
		
		Card firstCardDealer = new Card("7", 7);
		Card secondCardDealer = new Card("J", 10);
		
		Hand dealerHand = dealer.getHand();
		dealerHand.addCard(firstCardDealer);
		dealerHand.addCard(secondCardDealer);
		
		player.play(playerHand, dealer);
		dealer.play(dealerHand, dealer);
		
		BlackJackRunner.findWinner(player, dealer);
	}
	
	
	/**
	 * function that simulates the situation where the player and the dealer have a blackjack
	 */
	public static void playerAndDelaerHaveBlackJack() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		player.placeBet(10);
		
		dealer.shuffle();
		
		Card firstCardPlayer = new Card("A", 11);
		Card secondCardPlayer = new Card("10", 10);
		
		Hand playerHand = player.getHand();
		playerHand.addCard(firstCardPlayer);
		playerHand.addCard(secondCardPlayer);
		
		Card firstCardDealer = new Card("A", 11);
		Card secondCardDealer = new Card("10", 10);
		
		Hand dealerHand = dealer.getHand();
		dealerHand.addCard(firstCardDealer);
		dealerHand.addCard(secondCardDealer);
		
		player.play(playerHand, dealer);
		dealer.play(dealerHand, dealer);
		
		BlackJackRunner.findWinner(player, dealer);
	}
	
	
	/**
	 * function that simulates the situation where the player can split the hand
	 */
	public static void playerSplit() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		player.placeBet(10);
		
		dealer.shuffle();
		
		Card firstCardPlayer = new Card("A", 11);
		Card secondCardPlayer = new Card("A", 11);
		
		Hand playerHand = player.getHand();
		playerHand.addCard(firstCardPlayer);
		playerHand.addCard(secondCardPlayer);
		
		Card firstCardDealer = new Card("J", 10);
		Card secondCardDealer = new Card("5", 5);
		
		Hand dealerHand = dealer.getHand();
		dealerHand.addCard(firstCardDealer);
		dealerHand.addCard(secondCardDealer);
		
		player.play(playerHand, dealer);
		dealer.play(dealerHand, dealer);
		
		BlackJackRunner.findWinner(player, dealer);
	}
}
