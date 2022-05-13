package com.example.oopexceptionscases.case3;

public class C31 {
    public static void main(String[] args) {
        {
            System.out.println("main method");
            //finally then returned value
            System.out.println(Sample.foo("exception")); //exceptiontry
        }
    }
}



class Sample {
     static String foo(String str)
    {
        try {
            System.out.println(str.hashCode());
            str += "try";//a new object was returned bec string is immutable watch out the hash code
            //yeni bir nesne return edildi- uppercase gibi-finally her türlü calisacak
            //fakat sinif icinde kalan bir calisma bu
            System.out.println(str.hashCode());

            return str;
        }
        finally {
            System.out.println("finally block");
            str += "finally";
            System.out.println(str);//first finally then main method

        }
    }
}