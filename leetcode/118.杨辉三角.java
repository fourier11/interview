import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    private HashMap<String, Integer> coords = new HashMap<>();

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                row.add(getCoord(i, j));
            }
            result.add(row);
        }
        return result;
    }

    /**
     * 获取杨辉三角对应坐标的值
     * @param i 第i行
     * @param j 第j列
     */
    private int getCoord(int i, int j) {
        if (j == 1 || j == i) {
            return 1;
        }
        String key = String.valueOf(i) + "_" + String.valueOf(j);
        if (coords.containsKey(key)) {
            return coords.get(key);
        } else {
            int result = getCoord(i-1, j-1) + getCoord(i-1, j);
            coords.put(key, result);
            return result;
        }
    }
}
// @lc code=end

