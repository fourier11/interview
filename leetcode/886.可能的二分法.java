/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 * 
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 * 
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E4%B8%BA%E4%BB%80%E4%B9%88%E6%8E%A8%E8%8D%90%E7%AE%97%E6%B3%954.md
 * 
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 开两倍的数组，前半部分存放可以分在一组的人，后半部分存放自己不喜欢的人。
        UF uf = new UF(2 * N + 1);
        for (int i = 0; i < dislikes.length; i++) {
            int x = uf.find(dislikes[i][0]);// 查找自己的根节点
            int y = uf.find(dislikes[i][1]);// 不喜欢的人的根节点
            int a = uf.find(dislikes[i][0] + N);// 查找自己不喜欢的人群根节点
            int b = uf.find(dislikes[i][1] + N);// 自己不喜欢的人不喜欢的人群节点
            if (x == y) {
                return false;
            } else {
                uf.union(y, a);
                uf.union(x, b);
            }
        }
        return true;
    }

    private class UF {
        private int count;
        private int[] parent;

        public UF(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            count--;
        }
    }
}
// @lc code=end
