/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * 
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/color-fill-lcci
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] == oldColor && image[sr][sc] != newColor) {
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, oldColor);
            dfs(image, sr + 1, sc, newColor, oldColor);
            dfs(image, sr, sc - 1, newColor, oldColor);
            dfs(image, sr, sc + 1, newColor, oldColor);
        }
    }
}