package players;

import java.util.Scanner;

import cards.Card;
import cards.Hand;

public class Player extends BlackJackPlayer{

	private int bet;
	private boolean didSplit;
	private boolean didDoubleDown;
	private String playerInput;
	Scanner scanner;
	
	public Player() {
		super();
		scanner = new Scanner(System.in);
		setBet(0);
		setDidSplit(false);
		setDidDoubleDown(false);
	}
	
	
	/**
	 * main playing function that controls the order of actions.
	 */
	@Override
	public void play(Hand hand, Dealer dealer) {
		while(!stand) {
			
			printGameInfo(hand);
			
			outputActions(hand);
			// if blackjack, the player does not have to play
			if (stand) break;
			pickAction(hand, dealer);
		}
		// playing the split hand if there was a split
		if (hand.isSplit() && didSplit) {
			setStand(false);
			setDidSplit(false);
			play(splitHand, dealer);
		}
		//dealer.play(dealer.getHand(), dealer);
		
		System.out.println("FINISH");
	}
	
	
	/// HELPER FUNCTIONS ///
	
	/**
	 * function that outputs the possible actions that can be taken
	 * and handles some immediate cases. (like a blackjack)
	 * 
	 * @param hand : Hand
	 */
	public void outputActions(Hand hand) {
		// menu for the first round
		if (hand.isFirstRound()) {
			if (hand.isBlackJack()) {
				System.out.println("You have a BlackJack!");
				setStand(true);
				return;
			}
			if (hand.isRestricted()) {
				System.out.println("You hit 21!");
				setStand(true);
				return;
			}
			System.out.println("[H]it");
			System.out.println("[St]and");
			if (hand.isSplittable()) System.out.println("[Sp]lit");
			if (!didDoubleDown) System.out.println("[D]ouble Down");
		}
		// menu for the other rounds
		else {
			// when the player has a hand value higher than 21 the hand is bust
			if (hand.isBust()) {
				System.out.println("Bust!");
				setStand(true);
				return;
			}
			System.out.println("[H]it");
			System.out.println("[St]and");
			if (hand.canDoubleDown() && !didDoubleDown) System.out.println("[D]ouble Down");
		}
	}
	
	
	/**
	 * function that allows the user to pick an action and perform it.
	 * 
	 * @param hand : Hand
	 * @param dealer : Dealer
	 */
	public void pickAction(Hand hand, Dealer dealer) {
		playerInput = scanner.nextLine();
		if (playerInput.equals("H")) {
			System.out.println("\nHIT\n");
			hit(hand, dealer);
		}
		else if (playerInput.equals("St")) {
			System.out.println("\nSTAND\n");
			stand();
		}
		else if (playerInput.equals("Sp")) {
			System.out.println("\nSPLIT\n");
			split(dealer);
		}
		else if (playerInput.equals("D")) {
			System.out.println("\nDOUBLE DOWN\n");
			doubleDown(hand, dealer);
		}
	}
	
	
	/**
	 * function that prints the basic information about the round.
	 * 
	 * @param hand : Hand
	 */
	public void printGameInfo(Hand hand) {
		System.out.println("Cards:");
		System.out.println(hand);
		System.out.println();
		System.out.println("Current Bet: $" + bet);
		System.out.println();
		System.out.println("Current Value: " + hand.calculateValue());
		System.out.println();
	}
	
	
	/// POSSIBLE ACTIONS ///
	
	/**
	 * function that allows the user to increase the bet (only positive bets)
	 * 
	 * @param bet : integer
	 */
	public void placeBet(int bet) {
		if (bet > 0) this.bet += bet;
	}
	
	
	/**
	 * function that allows the user to get another card from the dealer
	 * 
	 * @param hand : Hand
	 * @param dealer : Dealer
	 */
	public void hit(Hand hand, Dealer dealer) {
		dealer.handCardToPlayer(hand);
	}
	
	
	/**
	 * function that allows the user to stand on a hand
	 */
	public void stand() {
		setStand(true);
	}
	
	
	/**
	 * function that allows the user to split the initial hand in two hands
	 * if the starting cards have the same number
	 * 
	 * @param dealer : Dealer
	 */
	public void split(Dealer dealer) {
		setDidSplit(true);
		setBet(getBet() * 2);
		
		Card splitCard = hand.getHand().get(1);		// get one of the cards in the hand
		hand.removeCard(1);							// delete the card taken from the hand
		splitHand.addCard(splitCard);				// add the card to the split hand
		
		hand.setIsSplit(true);
		splitHand.setIsSplit(true);
		
		dealer.handCardToPlayer(hand);				// hand two new cards
		dealer.handCardToPlayer(splitHand);			// one for each hand
	}
	
	
	/**
	 * function that allows the user to double the bet. Now the user
	 * only has to take a card and stand.
	 * 
	 * @param hand : Hand
	 * @param dealer : Dealer
	 */
	public void doubleDown(Hand hand, Dealer dealer) {
		setDidDoubleDown(true);
		dealer.handCardToPlayer(hand);
		setBet(getBet() * 2);
		setStand(true);
	}
	
	/// GETTERS AND SETTERS ///
	
	
	public boolean isDidDoubleDown() {
		return didDoubleDown;
	}

	public void setDidDoubleDown(boolean didDoubleDown) {
		this.didDoubleDown = didDoubleDown;
	}
	
	public String getPlayerInput() {
		return playerInput;
	}

	public void setPlayerInput(String playerInput) {
		this.playerInput = playerInput;
	}

	public boolean isDidSplit() {
		return didSplit;
	}

	public void setDidSplit(boolean didSplit) {
		this.didSplit = didSplit;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
	
	
	public static void main(String[] args) {
		
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		player.placeBet(10);
		
		dealer.shuffle();
		
		dealer.handCardToPlayer(player.getHand());
		dealer.handCardToPlayer(player.getHand());
		
		player.play(player.getHand(), dealer);
	}
	
}
