/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
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
            int rootQ= find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            count--;
        }
    }
}
// @lc code=end

