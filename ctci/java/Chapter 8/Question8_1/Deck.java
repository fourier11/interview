package Question8_1;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class Deck <T extends Card> {
	// 所有牌，包括已经发出去的，还未发出去的
	private ArrayList<T> cards; 
	private int dealtIndex = 0; // 标示第一张还未发出的牌
	
	public Deck() {
	}
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number) {
		if (remainingCards() < number) {
			return null;
		}
		
		T[] hand = (T[]) new Card[number];
		int count = 0;
		while (count < number) {
			T card = dealCard();
			if (card != null) {
				hand[count] = card;
				count++;
			}
		}
		
		return hand;
	}
	
	public T dealCard() {
		if (remainingCards() == 0) {
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;		
	}
	
	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}
