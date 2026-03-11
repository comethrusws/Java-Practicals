package com.example;

public class ConceptOOP{
    int data = 500;
    static int dl = 100;
    void msg(){
        System.out.println("Data is " + data);
    }
    public static void main(String[] args){
        ConceptOOP obj = new ConceptOOP();
        System.out.println(obj.data);
        System.out.println("Data is:"+obj.data);
        System.out.println("dl="+ dl);
        obj.msg();
    }
    
}

