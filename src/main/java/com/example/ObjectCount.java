package com.example;

public class ObjectCount{ // class declaration
    int count = 0; // instance variable
    public ObjectCount(){ // constructor
        count++;
    }

    public static int getCount(){ // static method - return type is int
        return count;
    }
    public static void main(String[] args){ // main method- return type is void
        ObjectCount obj1 = new ObjectCount(); // object instantiation
        ObjectCount obj2 = new ObjectCount();
        ObjectCount obj3 = new ObjectCount(); // new is a keyword which is used to create an object
        ObjectCount obj4 = new ObjectCount();
        System.out.println("Number of objects: " + obj4.count); // printing the count of objects
        System.out.println("Number of objects: " + obj1.getCount()); // printing the count of objects
    }
}


// instance variable/non-static variable:  its is a variable which is declared inside the class but outside the method 
// static variable/class variable:  its is a variable which is declared inside the class but outside the method and also declared as static
// local variable:  its is a variable which is declared inside the method