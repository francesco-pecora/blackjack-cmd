import java.util.Scanner;

import cards.Hand;
import players.Dealer;
import players.Player;

public class BlackJackRunner {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		playBlackJackRound();
	}
	
	public static void playBlackJackRound() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		System.out.println("WELCOME TO BLACKJACK");
		
		System.out.println("How much do you want to bet?");
		int bet = scanner.nextInt();
		
		player.placeBet(bet);
		
		dealer.shuffle();
		
		dealer.handCardToPlayer(player.getHand());
		dealer.handCardToPlayer(player.getHand());
		
		dealer.dealerGetsNewCard();
		dealer.dealerGetsNewCard();
		
		player.play(player.getHand(), dealer);
		dealer.play(dealer.getHand(), dealer);
		
		findWinner(player, dealer);
	}
	
	public static void findWinner(Player player, Dealer dealer) {
		Hand firstPlayerHand = player.getHand();
		Hand secondPlayerHand = player.getSplitHand();
		Hand dealerHand = dealer.getHand();
		
		System.out.println();
		System.out.print("Your hand is " + firstPlayerHand.calculateValue() + ". ");
		System.out.println("Dealer hand is " + dealerHand.calculateValue() + ".");
		
		// handling the blackjack case
		if (firstPlayerHand.isBlackJack() && !firstPlayerHand.isSplit()) {
			if (dealerHand.isBlackJack()) {
				System.out.println("This is a tie. You both have a blackjack");
			}
			else {
				System.out.println("You win with blackjack");
			}
		}
		
		compareHands(firstPlayerHand, dealerHand);
		
		if (firstPlayerHand.isSplit()) {
			System.out.println();
			System.out.print("Your hand is " + secondPlayerHand.calculateValue() + ". ");
			System.out.println("Dealer hand is " + dealerHand.calculateValue() + ".");
			compareHands(secondPlayerHand, dealerHand);
		}
	}
	
	public static void compareHands(Hand playerHand, Hand dealerHand) {
		
		int playerValue = playerHand.calculateValue();
		int dealerValue = dealerHand.calculateValue();
		
		if (playerHand.isBust()) {
			System.out.println("You lose");
		}
		else if (playerValue == dealerValue) {
			System.out.println("This is a tie");
		}
		else if (playerValue > dealerValue) {
			System.out.println("You win");
		}
		else {
			if (dealerHand.isBust()) {
				System.out.println("You win");
			}
			else {
				System.out.println("You lose");
			}
		}
	}

}
