package com.example.oopexceptionscases.case5;


import java.util.Objects;

public class KaplanExceptionRuntime extends RuntimeException {
    private final String s;

    {
        System.out.println("KaplanExceptionRuntime");
    }


    public KaplanExceptionRuntime(String s) {
        this.s = s;
        check();
    }

    public KaplanExceptionRuntime(Throwable cause, String s) {
        super(cause);
        this.s = s;
    }

    public KaplanExceptionRuntime(Throwable cause) {
        this(cause, "");
    }

    @Override
    public String getMessage() {
        System.out.println(s);
        Throwable cause = getCause();
        return String.format("Message:%s%s", super.getMessage(), cause != null ? ", Cause Message:" + super.getCause().getMessage() : " no information");
    }

    void check() {
        if (Objects.equals(s, "baran")) {
            System.out.println("you cant use baran as file name , change it !");
        }
    }
}

