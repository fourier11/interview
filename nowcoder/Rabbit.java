
/**
 * 兔子繁殖
 * 
 * 小兔子每三个月可以长大，长大后可以每月生一对，到达N个月时有几只兔子
 * 
 * https://www.zhihu.com/question/38045513
 */
public class Rabbit {
    public static void main(String[] args) {
        System.out.println("第1个月:" + fib(1));
        System.out.println("第2个月:" + fib(2));
        System.out.println("第3个月:" + fib(3));
        System.out.println("第4个月:" + fib(4));
        System.out.println("第5个月:" + fib(5));
        System.out.println("第1000个月:" + fib(1000));
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
