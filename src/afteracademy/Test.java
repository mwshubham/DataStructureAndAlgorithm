package afteracademy;

public class Test implements Cloneable {

    int a = 10;
    String b = "string";
    int[] arr = {1, 2, 3};

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test test = (Test) super.clone();
        test.arr = arr.clone();
        return test;
    }

    static {
        System.out.println("static");
    }

    public Test() {
        System.out.println("Test()");
    }


    public static void main(String args[]) {
        System.out.println("main()");
        Test obj1 = new Test();
        System.out.println(obj1);
        System.out.println(obj1.a);
        System.out.println(obj1.b);
        System.out.println(obj1.arr[0]);
        System.out.println(obj1.arr[1]);
        System.out.println(obj1.arr[2]);

//        Test obj2 = obj1;
//        System.out.println(obj2);
//        System.out.println(obj2);

        try {
            Test obj3 = (Test) obj1.clone();
            System.out.println(obj3);
            System.out.println(obj3.a);
            System.out.println(obj3.b);

            obj3.a = 11;
            obj3.b = "new string";
            obj3.arr[0] = 20;

            System.out.println(obj1.a);
            System.out.println(obj1.b);
            System.out.println(obj1.arr[0]);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}


