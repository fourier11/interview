/**
 * 求解数组中反序对的个数
 */
public class ReverseCount {
    /**
     * 蛮力法
     * @param arr
     * @return
     */
    public static int reverseCount(int[] arr) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,6};
        int count = reverseCount(arr);
        System.out.println(count);
    }
}