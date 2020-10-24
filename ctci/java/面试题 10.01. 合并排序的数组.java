/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 */
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int indexMerged = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexB >= 0) {
            if (indexA >= 0 && A[indexA] > B[indexB]) {
                A[indexMerged] = A[indexA];
                indexA--;
            } else {
                A[indexMerged] = B[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}