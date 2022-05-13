package com.example.oopexceptionscases.case5;


/*
How can the functional and reflection concept be internalized in exceptions?

    public static <T extends RuntimeException> void doWorkForRunnable(IActionCallback actionCallback, String msg, Class<T> cls)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            throwException(msg, cls, ex);
        }
    }
The ExceptionUtil class works with 2 functional interfaces named ActionCallback and Supplier callback,
they have various methods, some of them use reflection mechanisms.


IActionCallback is being taken outside the method
also a message is written

upper limit is RuntimeException

    public static <T extends RuntimeException> void doWorkForRunnable(IActionCallback actionCallback, String msg, Class<T> cls)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            throwException(msg, cls, ex);
        }
    }

With the reflection method, it takes the ctor and creates an exception object of that type and throws it!
so it will throw my message and exception object

    private static <T extends RuntimeException> void throwException(String msg, Class<T> cls, Throwable ex)
    {
        try {
            throw cls.getConstructor(String.class, Throwable.class).newInstance(msg, ex);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new UnsupportedOperationException("Fault for exception class");
        }
    }

 */


import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class C5 {


    static Random random;

    public static void main(String[] args) throws Exception {
        //information are above -
        //you don't have to deal with try catch
        //IActionCallback actionCallback = (() -> System.out.println("baran"));//works normally
        IActionCallback actionCallback = (() -> System.out.println(Integer.parseInt("baran ")));//works normally
        IActionCallback actionCallback2 = (() -> System.out.println(Integer.parseInt(" kaplan")));//works normally
                                                                                    //Throwable cause, String s
        Consumer<Throwable> consumer = (Throwable throwable) -> System.out.println(new KaplanException(throwable).getMessage()) ;

        ArrayList<Throwable> throwables= new ArrayList<>();
        Consumer<Throwable> consumer2 = throwables::add;

       ExceptionUtil.subscribeRunnable(actionCallback, consumer);

        System.out.println("---------");


        Class<? extends RuntimeException> myClass = KaplanExceptionRuntime.class;
        ExceptionUtil.doWorkForRunnable(actionCallback2,consumer2,"an ordinary message",myClass );

        System.out.println("ends");

    }

}





//why do interfaces need 'throws Exception'
interface A {
    void boo() throws Exception;
}

class B implements A {

    @Override
    public void boo() throws InterruptedException {
        Thread.sleep(10000);//this is a checked exception
        //if we want to throw it then abstract method
        //should include this exception
    }
}