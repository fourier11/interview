package Question18_2;

import CtCILibrary.AssortedMethods;

/**
 * 经典题目
 * 编写一个方法，洗一副牌。要求做到完美洗牌，换言之，这副牌的52!种排列组合出现的概率相同
 * 假设给定一个完美的随机数发生器
 * 
 * 算法：
 * 先打乱前n-1个元素的次序，然后取出第n个元素，将它与数组中的元素随机交换
 */
public class Question {

	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) { 
		return lower + (int)(Math.random() * (higher - lower + 1));
	}	
	
	public static int[] shuffleArrayRecursively(int[] cards, int i) {
		if (i == 0) {
			return cards;
		}
		
		/* shuffle elements 0 through index - 1 */
		shuffleArrayRecursively(cards, i - 1);
		int k = rand(0, i);		
		
		/* Swap element k and index */
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		/* Return shuffled array */
		return cards;
 	}
	
	public static void shuffleArrayInteratively(int[] cards) { 
		for (int i = 0; i < cards.length; i++) { 
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		} 
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffleArrayInteratively(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}

}
