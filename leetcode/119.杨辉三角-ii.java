/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    private HashMap<String, Integer> coords = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int j = 1; j <= rowIndex + 1; j++) {
           row.add(getCoord(rowIndex + 1, j)); 
        }
        return row;
    }

    /**
     * 获取杨辉三角对应坐标的值
     * 
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
            int result = getCoord(i - 1, j - 1) + getCoord(i - 1, j);
            coords.put(key, result);
            return result;
        }
    }
}
// @lc code=end

