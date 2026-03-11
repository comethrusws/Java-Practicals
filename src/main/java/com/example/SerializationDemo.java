package com.example;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

class Employee implements Serializable { // converts object into bytes
    int id;
    String name;
    String address;
    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public String toString() {
        return "hi, my name is " + name + " and my address is " + address + ", and my employee id is: " + id;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Basab", "123 hahaha street");
        Employee emp2 = new Employee(2, "Basab's evil dopleganger", "456 huhuhuh street");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        String fileName = "employees.txt";

        String contentToWrite = emp1.toString() + "\n" + emp2.toString();
        System.out.println("Writing to file: " + fileName);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = contentToWrite.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n---------------------------------------------");


        System.out.println("reading back from file: " + fileName);
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\nSuccessfully read from the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}