import java.util.Scanner;

import players.Dealer;
import players.Player;

public class BlackJackRunner {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playBlackJackRound();
	}
	
	public static void playBlackJackRound() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		System.out.println("WELCOME TO BLACKJACK");
		
		System.out.println("How much do you want to bet?");
		int bet = scanner.nextInt();
		
		player.placeBet(bet);
		System.out.println("Placed a bet of $" + bet);
		
		dealer.shuffle();
		
		dealer.handCardToPlayer(player.getHand());
		dealer.handCardToPlayer(player.getHand());
		
		dealer.dealerGetsNewCard();
		dealer.dealerGetsNewCard();
		
		player.play(player.getHand(), dealer);
		dealer.play(dealer.getHand(), dealer);
	}

}
