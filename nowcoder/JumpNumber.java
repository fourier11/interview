import java.util.Scanner;

/**
 * 数字从1开始，遇到数字7就会跳过，比如6后边直接是8，69后边直接是80，现在给你个数字，问是第几位？
 * 
 * 比如输入8，输出7，就是第7个数。那89那？请你编程输出。(目标数字不大于100)
 */
class JumpNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("target: " + target);
        int index = 0;
        for (int i = 1; i <= target; i++) {
            if (i % 10 == 7 || i / 10 == 7) {
                continue;
            }
            index++;
        }
        System.out.println("index: " + index);
    }
}