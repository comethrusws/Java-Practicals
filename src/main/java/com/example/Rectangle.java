package com.example;

public class Rectangle{
    int length;
    int width;
    public Rectangle(int length, int width){  // length and breadth are parameters
        //constructor; a method that does not have a return type
    // it is invoked when an object is created
    // it is of two types: parameterized constructor and non-parameterized constructor
    // parameterized constructor: a constructor that has parameters
    // non-parameterized constructor: a constructor that does not have parameters
    // it is of same name as the class
    // default constructor: a constructor that is created by the compiler
        this.length = length; // this is a keyword which is used to refer to the current object
        this.width = width;
    }

    public int getArea(){ //method
        return length * width;
    }

    public void SetData(int length, int width){
        this.length = length;
        this.width = width;
    }

    public static void main(String[] args){
        Rectangle rect1 = new Rectangle(10, 20);
        Rectangle rect2 = new Rectangle(30, 40);
        System.out.println("Area of rect1: " + rect1.getArea());
        System.out.println("Area of rect2: " + rect2.getArea());
        rect1.SetData(50, 60);
        System.out.println("Area of rect1 with setdata: " + rect1.getArea());
    }
}
