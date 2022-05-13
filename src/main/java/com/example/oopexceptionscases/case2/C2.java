package com.example.oopexceptionscases.case2;

import java.util.Random;

public class C2 {
    public static void main(String[] args) throws MyException {
        new B().foo();
    }
}

class Sample {
    public static void bar(int val) throws YourException {
        if (val == 0)
            throw new YourException();
    }
}

class B extends A {
    public void foo() throws MyException {


        try {
            Sample.bar(0);//throws YourException
            //throw new YourException();//won't be a problem here bec will be caught!
        } catch (YourException ex) {//throws YourException will be caught

            //method is inherited,do you want to add exceptions to method signatures in the whole method hierarchy?
            //that's not possible!
            //throw new YourException(); can't be thrown !
            //this is where a wrapper exceptions a good solution!
            System.out.println(new WrapperException("Wrapper", ex).getMessage());
            throw new WrapperException("Wrapper", ex);
            //return String.format("Message:%s%s", super.getMessage(), cause != null ? ", Cause Message:" + super.getCause().getMessage() : "");
        }
        try {
            if (new Random().nextBoolean())
                throw new MyException();
        } catch (MyException ex) {
            //throw new MyException();//can be added to method signature thanks to the
            //inheritance  public abstract void foo() throws MyException
            //a perfect way to show inheritance and polymorphism
            //we can attach MyException upcasting via extends Exception
            //thanks to the polymorphism getMessage works in a dynamic way.same methods in different classes works properly
            System.out.println(new WrapperException("Wrapper", ex).getMessage());
            throw new WrapperException("Wrapper", ex);
        }
    }
}


class WrapperException extends RuntimeException {
    public WrapperException(String message) {
        super(message);
    }

    public WrapperException(String message, Throwable cause) {
        super(message, cause);//YourException is the cause
    }

    public String getMessage() {
        Throwable cause = getCause();//now i take the cause getCause metodu ile içsel olarak tutulan exception
        //referansı Throwable türünden elde edilir
        //cause=com.example.oopexceptionscases.case2.YourException:  YourException
        return String.format("Message:%s%s", super.getMessage(), cause != null ? ", Cause Message:" + super.getCause().getMessage() : " no information");
    }
}

abstract class A {
    public abstract void foo() throws MyException;
}

class MyException extends Exception {
    @Override
    public String getMessage() {
        return " My Exception ";
    }
}

class YourException extends Exception {
    @Override
    public String getMessage() {
        return " YourException ";
    }
}
