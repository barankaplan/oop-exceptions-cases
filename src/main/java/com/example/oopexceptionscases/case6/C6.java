package com.example.oopexceptionscases.case6;

import java.util.Scanner;


class AppKaplan {
    public static void main(String[] args) {

        //using exceptions to have a certain number of tries when a wrong value is entered
        int a = C6.readInt("first number : ", "incorrect");
        System.out.println(a);
    }
}

public final class C6 {
    private static int count;
    private static final Scanner ms_kb;

    //remember static blocks -private static final Scanner ms_kb = new Scanner(System.in) de denebilirdi
    static {
        ms_kb = new Scanner(System.in);
    }

    private C6() {

    }

    public static int readInt(String message, String errMessage) {

        for (; ; ) {

            try {
                System.out.println(message);
                return Integer.parseInt(ms_kb.nextLine());


            } catch (NumberFormatException ex) {
                ++count;
                System.out.println(errMessage);
                if (count == 5) {
                    System.out.println("We returned 0 because you tried 5 times");
                    return 0;
                }
                System.out.println("not readable! you have " + (5 - count) + " chance");

            }
        }
    }

    public static int readInt(String message) {
        return readInt(message + "\n", "" + "\n");
    }

    public static int readInt() {
        return readInt("" + "\n");
    }


}
