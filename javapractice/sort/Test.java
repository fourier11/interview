package sort;

public class Test {
    public static void main(String[] args) {
        Insertion<Integer> insertion = new Insertion<>();
        Integer[] nums = {5,3,2,9,1,0,2,4,8};
        insertion.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}