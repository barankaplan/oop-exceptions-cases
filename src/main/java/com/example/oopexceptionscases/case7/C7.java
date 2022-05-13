package com.example.oopexceptionscases.case7;

/*----------------------------------------------------------------------------------------------------------------------
a basic checked exception should be handled or thrown
----------------------------------------------------------------------------------------------------------------------*/


import java.util.Scanner;

class C7 {
    public static void main(String [] args) throws MyException {
        try {
            Scanner kb = new Scanner(System.in);

            System.out.print("Bir sayı giriniz:");
            double val = Double.parseDouble(kb.nextLine());
            double result = MathUtil.myLog(val);

            System.out.printf("log(%f)=%f%n", val, result);
        }
        catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("main ends");
    }
}

class MathUtil {
    public static double myLog(double val) throws MyException
    {
        if (val < 0)
            throw new MyException("val can not be negative");

        if (val == 0)
            throw new MyException("val can not be zero");

        return Math.log(val);
    }
}

class MyException extends Exception {
    public MyException(String message)
    {
        super(message);
    }
}
