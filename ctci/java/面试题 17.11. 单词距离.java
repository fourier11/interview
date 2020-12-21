/**
 * 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-closest-lcci
 */
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int t1 = -1;
        int t2 = -1;
        int res = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                t1 = i;
            } else if (words[i].equals(word2)) {
                t2 = i;
            }
            if (t1 != -1 && t2 != -1) {
                res = Math.min(res, Math.abs(t1 - t2));
            }
            if (res == 1) {
                return res;
            }
        }
        return res;
    }
}