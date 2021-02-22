import java.util.Scanner;

/**
 * 兔子繁殖
 * 
 * 小兔子每三个月可以长大，长大后可以每月生一对，到达N个月时有几只兔子
 * 
 * https://www.zhihu.com/question/38045513
 */
public class Rabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = fib(n);
        System.err.println(res);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
