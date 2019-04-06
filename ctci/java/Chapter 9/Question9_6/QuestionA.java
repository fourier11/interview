package Question9_6;

import java.util.HashSet;
import java.util.Set;
/**
 * 打印 n 对括号的全部有效组合。（即左右括号正确配对）
 * 解法：
 * 运用递归，从 n-1 的解答找到 n的解答
 * 在字符串最前面以及原有的每对括号里面插入一对括号。末尾不能插入，因为会跟之前重复
 * A 解法效率不够高，需要排查重复字符串
 */
public class QuestionA {
	public static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}
	
	public static Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1); 
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						/* Add s to set if it is not already in there. Note: 	
						 * HashSet automatically checks for duplicates before
						 * adding, so an explicit check is not necessary. */
						set.add(s);			
					}
				}
				set.add("()" + str);
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		Set<String> list = generateParens(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
