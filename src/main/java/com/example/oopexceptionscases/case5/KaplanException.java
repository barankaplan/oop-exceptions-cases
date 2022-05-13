package com.example.oopexceptionscases.case5;

import java.util.Objects;

public class KaplanException extends Throwable  {
    private final String s;

    {
        System.out.println("KaplanException");
    }


    public KaplanException(String s) {
        this.s=s;
        check();
    }

    public KaplanException(Throwable cause, String s) {
        super(cause);
        this.s = s;
    }
    public KaplanException(Throwable cause) {
        this(cause,"");
    }
    public String getMessage() {
        System.out.println("getMessage in KaplanException works!");
        Throwable cause = getCause();
        return String.format("Message:%s%s", super.getMessage(), cause != null ? ", Cause Message:" + super.getCause().getMessage() : " no information");
    }

    void check(){
        if (Objects.equals(s, "baran")){
            System.out.println("you cant use baran as file name , change it !");
        }
    }
}
