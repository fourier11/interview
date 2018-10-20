

public class MergeArray {
    // 对数组的两个子有序段进行合并，a[0, mid - 1] 和 a[mid, n - 1] 各自有序，要求算法空间复杂度为 O(1)
    public static void sort(int[] a, int mid) {
        int tmp;
        for (int i = 0; i <= mid - 1; i++) {
            if (a[mid] < a[i]) {
                tmp = a[i];
                a[i] = a[mid];
                a[mid] = tmp;
                findRightPlaceForMid(a, mid);
            }
        }
    }

    // 下面这个方法应用到了插入排序的思想
    private static void findRightPlaceForMid(int[] a, int mid) {
        int len = a.length;
        int tmp;
        for (int i = mid; i < len - 1; i++) {
            if (a[i + 1] < a[i]) {
                tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 6, 7, 9, 2, 4, 8, 10, 13, 14 };
        sort(a, 5);
        for (int i = 0; i < 11; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
