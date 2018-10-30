package Question1_1;
/**
 * 确认一个字符串的所有字符是否全都不同
 */
public class Question {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			// 这里用到了位操作，不是很理解，有空再深入看看
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		// 字符的索引最多是128吗？需要再确认
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}

}
