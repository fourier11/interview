import java.util.Arrays;
import java.util.Stack;

/**
 * 给一个数组，收尾相连，按照顺序找到比自己大的第一个数，找不到的存-1。
 * 
 * 例如[35,25,48,37] ->输出[48,48,-1,48]
 * 
 * 同leetcode 503 题
 */
public class FindLarger {
    public static void main(String[] args) {
        int[] arr = new int[] { 35, 25, 48, 37 };
        int[] res = findLarger(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] findLarger(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && arr[i % n] > arr[stack.peek()]) {
                res[stack.pop()] = arr[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}