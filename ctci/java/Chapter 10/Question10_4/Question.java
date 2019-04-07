package Question10_4;

import CtCILibrary.AssortedMethods;

/**
 * 给定一个数组，包含1到N的整数，N最大为32000，数组可能含有重复的值，且N的取值不定。若只有4KB内存可用，
 * 该如何打印数组中所有重复的元素
 * 解法：
 * 可以创建含有32000个比特的位向量，其中每个比特代表一个整数
 */
public class Question {

	public static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) { 
				System.out.println(num);
			} else {
				bs.set(num0);				
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(30, 1, 30);
		System.out.println(AssortedMethods.arrayToString(array));
		checkDuplicates(array);
	}

}
