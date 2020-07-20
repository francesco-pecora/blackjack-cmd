import java.util.Scanner;

import cards.Hand;
import players.Dealer;
import players.Player;

public class BlackJackRunner {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO BLACKJACK");
		
		while (true) {
			playBlackJackRound();
			
			System.out.println("Play Again? [Y]es [N]o");
			String playAgain = scanner.next();
			if (playAgain.equals("N")) {
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
	
	public static void playBlackJackRound() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		System.out.println("How much do you want to bet?");
		int bet = scanner.nextInt();
		
		player.placeBet(bet);
		
		dealer.shuffle();
		
		dealer.handCardToPlayer(player.getHand());
		dealer.handCardToPlayer(player.getHand());
		
		dealer.dealerGetsNewCard();
		dealer.dealerGetsNewCard();
		
		player.play(player.getHand(), dealer);		
		if (player.getHand().isBust() && !player.isDidSplit()) {
			System.out.println("Your hand is bust." + " You lose this hand. -$" + player.getBet() + " initial bet.");
		}
		else {
			dealer.play(dealer.getHand(), dealer);
			findWinner(player, dealer);
		}
		
		
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
				System.out.println("This is a tie. You both have a blackjack. You receive the initial bet back. +$" + player.getBet() + ".");
			}
			else {
				System.out.println("You won with blackjack. +$" + player.getBet() + " initial bet, +$" + (3.0/2) * player.getBet() + " winnings.");
			}
			return;
		}
		
		compareHands(player, firstPlayerHand, dealer, dealerHand);
		
		if (firstPlayerHand.isSplit()) {
			System.out.println();
			System.out.print("Your hand is " + secondPlayerHand.calculateValue() + ". ");
			System.out.println("Dealer hand is " + dealerHand.calculateValue() + ".");
			compareHandsSplit(player, secondPlayerHand, dealer, dealerHand);
		}
	}
	
	public static void compareHands(Player player, Hand playerHand, Dealer dealer, Hand dealerHand) {
		
		int playerValue = playerHand.calculateValue();
		int dealerValue = dealerHand.calculateValue();
		
		if (playerHand.isBust()) {
			System.out.println("You lose this hand. -$" + player.getBet() + " initial bet.");
		}
		else if (playerValue == dealerValue) {
			System.out.println("This is a tie. You receive the initial bet back. +$" + player.getBet() + ".");
		}
		else if (playerValue > dealerValue) {
			System.out.println("You won +$" + player.getBet() + " initial bet, +$" + player.getBet() + " winnings.");
		}
		else {
			if (dealerHand.isBust()) {
				System.out.println("You won +$" + player.getBet() + " initial bet, +$" + player.getBet() + " winnings.");
			}
			else {
				System.out.println("You lose this hand. -$" + player.getBet() + " initial bet.");
			}
		}
	}
	
	public static void compareHandsSplit(Player player, Hand playerHand, Dealer dealer, Hand dealerHand) {
		
		int playerValue = playerHand.calculateValue();
		int dealerValue = dealerHand.calculateValue();
		
		if (playerHand.isBust()) {
			System.out.println("You lose this hand. -$" + player.getSplitBet() + " initial bet.");
		}
		else if (playerValue == dealerValue) {
			System.out.println("This is a tie. You receive the initial bet back. +$" + player.getSplitBet() + ".");
		}
		else if (playerValue > dealerValue) {
			System.out.println("You won +$" + player.getSplitBet() + " initial bet, +$" + player.getSplitBet() + " winnings.");
		}
		else {
			if (dealerHand.isBust()) {
				System.out.println("You won +$" + player.getSplitBet() + " initial bet, +$" + player.getSplitBet() + " winnings.");
			}
			else {
				System.out.println("You lose this hand. -$" + player.getSplitBet() + " initial bet.");
			}
		}
	}
}
