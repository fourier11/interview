import java.lang.instrument.Instrumentation;

public class BooleanSize {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static void main(String[] args) {
        boolean b = true;
        boolean[] boolArray = new boolean[10];

        System.out.println("Size of boolean: " + instrumentation.getObjectSize(b) + " bytes");
        System.out.println("Size of boolean array: " + instrumentation.getObjectSize(boolArray) + " bytes");
    }
}
