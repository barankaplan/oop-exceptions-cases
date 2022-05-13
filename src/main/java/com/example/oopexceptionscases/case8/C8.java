package com.example.oopexceptionscases.case8;

import java.util.Scanner;

public class C8 {

    // some inheritance
    public static void main(String[] args) {
        try {
            Scanner kb = new Scanner(System.in);

            System.out.print("enter a number:");
            double val = Double.parseDouble(kb.nextLine());
            double result = MathUtil.myLog(val);

            System.out.printf("log(%f)=%f%n", val, result);
        } catch (MyException ex) {
            System.out.printf("Exception message:%s%n", ex.getMessage());
        }
    }
}

class MathUtil {
    public static double myLog(double val) {
        if (val < 0)
            throw new MyException("val can not be negative");

        if (val == 0)
            throw new MyException("val can not be zero");

        if (val == 1)
            throw new KaplanException("this message goes to super!", "a message my own ctor " +
                    "message in the super won't be displayed");


        return Math.log(val);
    }
}

class KaplanException extends MyException {
    private final String m_message;


    public KaplanException(String message, String m_message) {
        //super is obligatory no default ctor
        super(message);
        //this(); Call to 'this()' must be first statement in constructor body remember
        this.m_message = m_message;
    }

    @Override
    public String getMessage() {
        return  m_message;//important! super.getMessage()+
    }
}

class MyException extends RuntimeException {
    private final String m_message;

    public MyException(String message) {
        m_message = message;
    }

    @Override
    public String getMessage() {
        return m_message;
    }
}
