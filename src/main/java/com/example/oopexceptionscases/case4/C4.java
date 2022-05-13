package com.example.oopexceptionscases.case4;



import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {

        //enter 0 and my exception will be thrown-finally works in any case, that's pretty logical
        //because some operation should be done before thrown an Exception

        //but we can't see System.out.println("end of foo method")

        //they can be caught in main method

        try {
            Sample.foo();
            System.out.println("main:end of try block-won+t be written if an exception is thrown");
        } catch (YourException ex) {
            System.out.println("main:YourException caught");
        } catch (MyException ex) {
            System.out.println("main:MyException caught");
            //return; // we can't see end of C4 class
        } finally {
            //return; Remove this redundant jump. yazisi gleceketir
            System.out.println("main:finally");
        }

        System.out.println("end of C4 class");
    }
}

class Sample {
    public static void foo() {
        try (Scanner kb = new Scanner(System.in);) {
            System.out.print("Enter a value:");
            double val = Double.parseDouble(kb.nextLine());

            System.out.printf("log(%.2f) = %f%n", val, MathUtil.myLog(val));
            System.out.println("foo:end of try block");
        } finally {
            System.out.println("foo:finally");

        }

        System.out.println("end of foo method");
    }
}

class MathUtil {
    public static double myLog(double val) {
        if (val == 0)
            throw new MyException();

        if (val < 0)
            throw new YourException();

        return Math.log(val);
    }
}

class MyException extends RuntimeException {
    //...
}

class YourException extends RuntimeException {
    //...
}
