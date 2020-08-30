package sort.insert;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Insertion<Integer> insertion = new Insertion<>();
        Integer[] nums = {5,3,2,9,1,0,2,4,8};
        System.out.println("排序前:");
        System.out.println(Arrays.asList(nums));
        insertion.sort(nums);
        System.out.println("排序后:");
        System.out.println(Arrays.asList(nums));
    }
}