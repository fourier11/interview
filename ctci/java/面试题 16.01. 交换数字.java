/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 */
class Solution {
    public int[] swapNumbers(int[] numbers) {
        int a = numbers[0] - numbers[1];
        int b = a + numbers[1];
        a = b - a;
        return new int[] { a, b };
    }
}