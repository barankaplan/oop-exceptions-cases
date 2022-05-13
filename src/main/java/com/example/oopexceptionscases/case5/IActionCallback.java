/*----------------------------------------------------------------------
FILE        : IActionCallback.java
AUTHOR      : Oğuz Karan
LAST UPDATE : 30.09.2020

IActionCallback functional interface

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package com.example.oopexceptionscases.case5;

@FunctionalInterface
public interface IActionCallback {
    void run() throws Exception;
}
