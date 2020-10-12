/**
 * 全组合，不存在相同字符
 */
public class Arranges {
    public static void arranges(char[] c) {
        int n = c.length;
        //左移n位，相当于1 * 2^n,总共有2^n - 1种方案，0是无效的
        int nbit = 1 << n;
        for (int i = 1; i < nbit; i++) {
            System.out.println("组合数值" + i + "对应编码为：");
            for (int j = 0; j < n; j++) {
                int temp = 1 << j;
                if ((temp & i) != 0) {
                    System.out.print(c[j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c'};
        arranges(c);
    }
}
