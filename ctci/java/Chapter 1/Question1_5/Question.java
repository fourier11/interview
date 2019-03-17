package Question1_5;
/**
 * 字符串压缩功能，利用字符重复出现的次数，编写一个方法，实现基本字符串压缩功能。比如“aabbbcccc”变成“a2b3c4”
 */
public class Question {

	public static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	public static int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			} 
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	/**
	 * 最容易理解的解法，但是效率偏低。
	 */
	public static String compressBad(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				//对count进行重置
				count = 1;
			}
		}
		return mystr + last + count;
	}
	
	public static String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		// 其实推荐用 StringBuilder，效率更高一点
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				// 插入字符的数目，更新last字符
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		// 最后一组重复字符还未放入压缩字符串中，需要额外放入一下
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}	
	
	/**
	 * 不用StringBuffer的版本，也比较高效
	 */
	public static String compressAlternate(String str) {
		// 检查压缩后的字符串是否会变得更长
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		// 以最后一组重复字符更新字符串
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
		String str = "abbccccccde";
		int c = countCompression(str);
		String str2 = compressAlternate(str);
		String t = compressBetter("");
		System.out.println("Compression: " + t);
		System.out.println("Old String (len = " + str.length() + "): " + str);
		System.out.println("New String (len = " + str2.length() + "): " + str2);
		System.out.println("Potential Compression: " + c);
	}
}
