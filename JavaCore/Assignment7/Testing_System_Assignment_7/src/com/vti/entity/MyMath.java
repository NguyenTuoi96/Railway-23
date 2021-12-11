package com.vti.entity;

//a) Viết class MyMath để thay thế cho class Math của java.
//b) Viết thêm method min(), sum vào class MyMath
public class MyMath {
    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }
    
    public static int sum(int a, int b) {
        return a + b;
    }
}
