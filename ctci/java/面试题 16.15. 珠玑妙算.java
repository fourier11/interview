/**
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB
 * 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * 
 */
class Solution {
    public int[] masterMind(String solution, String guess) {
        int real = 0;
        int fake = 0;
        int[] map = new int[256];
        for (int i = 0; i < guess.length(); i++) {
            char sol = solution.charAt(i);
            char gue = guess.charAt(i);
            if (sol == gue) {
                real++;
            } else {
                if (map[sol] < 0) {
                    fake++;
                }
                map[sol]++;
                if (map[gue] > 0) {
                    fake++;
                }
                map[gue]--;
            }
        }
        return new int[] { real, fake };
    }
}