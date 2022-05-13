package com.example.oopexceptionscases.case3;

public class C32 {
    public static void main(String[] args) {
        System.out.println(Sample322.foo("exception")); //exceptiontry
        System.out.println(Sample321.foo("exception")); //exceptiontryfinally

    }

}


class Sample322 {
    public static String foo(String str) {
        MutableString result = new MutableString(str);

        try {
            return result.append("try").toString();//we return A NEW STRING
        } finally {
            System.out.println("before this block we returned A NEW STRING" +
                    " this object has nothing to do in finally class " +
                    "that's why exceptiontry will be printed " +
                    "finally block-mutable class");
            result.append("finally");
            System.out.println(result);
        }
    }
}

class Sample321 {
    public static MutableString foo(String str) {
        MutableString result = new MutableString(str);

        try {
            return result.append("try");//firlatmiyor ani nesne
        } finally {
            System.out.println("finally block-mutable class");
            result.append("finally");
            System.out.println(result);
        }
    }
}

class MutableString {//a basic mutable string
    private String m_str;

    public MutableString(String str) {
        this.setStr(str);
    }

    public void setStr(String str) {
        m_str = str;
    }

    //...

    public MutableString append(String str) {

        m_str += str;

        return this;//this is really important bec we return the class , which means the same object reference
    }

    //...

    public String toString() {
        return m_str;
    }
}
