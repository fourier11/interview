import java.util.Scanner;

/**
 * 勾股定理
 * 
 * 给定一个区间，找出所有的可以组成a*a + b*b = c*c的组合，例如[2,10]，可以找出两组：3 4 5；6 8 10。
 */
public class PythagoreanTheorem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        for (int a = start; a <= end; a++) {
            for (int b = a + 1; b <= end; b++) {
                for (int c = b + 1; c <= end; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
    }

}
