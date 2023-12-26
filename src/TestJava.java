import java.util.ArrayList;
import java.util.List;

public class TestJava {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    static void swap(Integer a, Integer b) {
        int temp = a;
        a = new Integer(b.intValue());
        b = new Integer(temp);
    }
}
