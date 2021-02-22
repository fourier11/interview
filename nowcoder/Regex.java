import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 7. 字串查找，正则模糊匹配，输出找到字串的位置。
 * 
 * 给出一个字符串，给出一个正则白表达式子串，找出可以找到子串的第一个位置。
 * 
 * 例如:字符串asdfas，子串是d[sf]，（[]表示里边任意一个元素），输出为3，因为ds或df去匹配字符串，找到df输出位置为3。
 */
public class Regex {
    private static final String REGEX = "d[sf]";
    private static final String INPUT = "asdfas";

    public static void main(String args[]) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while (m.find()) {
            count++;
            // System.out.println("Match number "+count);
            System.out.println(/* "start(): " */m.start() + 1);
            // System.out.println("end(): "+m.end());
        }
    }
}
