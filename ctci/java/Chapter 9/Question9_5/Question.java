package Question9_5;

import java.util.*;
/**
 * 非常经典的全排列问题，非常容易考，给出一个字符串的所有排列组合。
 * 问题：如果出现重复字符，这个解法有问题，会多数一些排列
 */
public class Question {

	public static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // 终止条件
			permutations.add("");
			return permutations;
		}
	            
		char first = str.charAt(0); // 取得第一个字符
		String remainder = str.substring(1); // 移除第一个字符
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abcd");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
