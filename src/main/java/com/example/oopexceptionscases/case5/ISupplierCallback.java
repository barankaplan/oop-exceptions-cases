/*----------------------------------------------------------------------
FILE        : ISupplierCallback.java
AUTHOR      : Oğuz Karan
LAST UPDATE : 30.09.2020

ISupplierCallback<T> functional interface

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package com.example.oopexceptionscases.case5;

@FunctionalInterface
public interface ISupplierCallback<R> {

    //checked exc basimiza bela olmasin diye yaptik
    //java nin functional inerface leri exception firlatabilecke sekilde
    //yazilmadiig icin chkeced exceptionlari mutlaka iceri handle etmek zorundayiz!
    R get() throws Exception;
}
