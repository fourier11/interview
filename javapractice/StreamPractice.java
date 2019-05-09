import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        // IntStream.range(1, 10).forEach(System.out::println);
        
        //熟悉 ifPresent 方法，如果为 null，可以什么都不执行
        // Arrays.stream(new int[] {}).map(n -> 2*n + 1).average().ifPresent(e -> System.out.println("test"));
        
        // 重点关注mapToInt方法
        // Stream.of("a1", "a2", "a3")
        //     .map(s -> s.substring(1))
        //     .mapToInt(Integer::parseInt)
        //     .max()
        //     .ifPresent(System.out::println);

        // mapToObj用法
        // IntStream.range(1,4).mapToObj(e -> "a" + e).forEach(System.out::println);


        // 流是链式执行的
        // Stream.of("d2", "a2", "b1", "a3", "c").map(s ->{
        //     System.out.println("map:" + s);
        //     return s.toUpperCase();
        // }).anyMatch(s -> {
        //     System.out.println("anyMatch: " + s);
        //     return s.startsWith("A");
        // });

        // 减少执行次数，把filter放在前面更合适

        // 并行流
        Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
                System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                return true;
            }).map(s -> {
                System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                return s.toUpperCase();
            }).sorted((s1, s2) -> {
                System.out.format("sorted: %s<>%s [%s]\n", s1, s2, Thread.currentThread().getName());
                return s1.compareTo(s2);
            }).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));


    }
}