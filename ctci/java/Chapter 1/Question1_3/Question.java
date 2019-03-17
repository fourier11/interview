package Question1_3;
/**
 * 给定两个字符串，编写程序，确定其中一个字符串的字符重新排列后能否编程另一个字符串
 * 解法一：排序字符串。只需要比较排序后的字符串
 */
public class Question {	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		//验证一下拼接后的字符串是否有逗号
		System.out.println(new String(content));
		return new String(content);
	}

	public static boolean permutation(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	/**
	 * 仅用于重排字符串，并判断
	 */
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		/**ASCII码占用一个字节，可以有0～255共256个取值。前128个为常用的字符如运算符，字母 ，数字等 键盘上可以显示的.
		 * 后128个为 特殊字符是键盘上找不到的字符。*/
		int[] letters = new int[128];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					return true;
					//return i == t.length() - 1;
				}
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			// 这里已经得出结果，anagram 用于对字符串重排
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
			System.out.println(anagram(word1, word2));
		}
	}
}
