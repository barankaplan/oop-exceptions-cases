package com.example.oopexceptionscases.case9;

import java.util.Scanner;

class BLTC1 extends ClassNotFoundException {
    public static void main(String[] args) //throws ClassNotFoundException
    {

        double x = 0;
        System.out.println("enter a value");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                x = Double.parseDouble(sc.nextLine());
                System.out.println(myLog(x));
                System.out.println("it was " + x + " if its negative is going to try catch ");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("not a number");
                System.out.println("enter a valid number");
            } catch (MyException ex) {
                System.out.println("it is negative and this is how i catched it!");
                System.out.println("and this is how i solved!");
                System.out.println(reverse(x));
                break;
            }catch (Throwable ex){
                ex.printStackTrace();
            }


        }
        System.out.println("if you use return you couldn't see this line ");

    }

    private static double reverse(double a) {
        return myLog(a * -1);
    }

    public static double myLog(double val) {
        if (val <= 0) {

            throw new MyException().message();
        }
        return val;
        //...
    }


}

class MyException extends RuntimeException {
    MyException message() {
        System.out.println("we throw an exception");
        return this;
    }
}
