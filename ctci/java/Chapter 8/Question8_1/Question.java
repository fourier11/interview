package Question8_1;

import java.util.ArrayList;

/**
 * 请设计用于通用扑克牌的数据结构，并说明你会如何创建该数据结构的子类，实现“二十一点”游戏
 */
public class Question {

	
	public static void main(String[] args) {	
		int numHands = 5;
		
		BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
		automator.initializeDeck();
		boolean success = automator.dealInitial();
			if (!success) {
				System.out.println("Error. Out of cards.");
			} else {
			System.out.println("-- Initial --");
			automator.printHandsAndScore();
			ArrayList<Integer> blackjacks = automator.getBlackJacks();
			if (blackjacks.size() > 0) {
				System.out.print("Blackjack at ");
				for (int i : blackjacks) {
					System.out.print(i + ", ");
				}
				System.out.println("");
			} else {
				success = automator.playAllHands();
				if (!success) {
					System.out.println("Error. Out of cards.");
				} else {
					System.out.println("\n-- Completed Game --");
					automator.printHandsAndScore();
					ArrayList<Integer> winners = automator.getWinners();
					if (winners.size() > 0) {
						System.out.print("Winners: ");
						for (int i : winners) {
							System.out.print(i + ", ");
						}
						System.out.println("");
					} else {
						System.out.println("Draw. All players have busted.");
					}
				}
			}
		}
	}

}
