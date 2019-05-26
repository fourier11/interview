package Question18_8;

import java.util.ArrayList;

/**
 * 给定一个字符串s和一个包含较短字符串的数组T，设计一个方法，根据T中的每一个较短字符串，对s进行搜索
 */
public class Question {
	public static void main(String[] args) {
		String testString = "mississippi";
        String[] stringList = {"is", "sip", "hi", "sis"};
        SuffixTree tree = new SuffixTree(testString);
		for (String s : stringList) {
        	ArrayList<Integer> list = tree.search(s);
        	if (list != null) {
        		System.out.println(s + ": " + list.toString());
        	}
		}
	}
}