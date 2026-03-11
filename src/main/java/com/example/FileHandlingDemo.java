package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlingDemo {

    public static void main(String[] args) {
        String fileName = "output_demo.txt";
        String contentToWrite = "we eat rice. i eat rice. they eat rice";

        System.out.println("Writing to file: " + fileName);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = contentToWrite.getBytes();
            fos.write(bytes);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");

        System.out.println("Reading from file: " + fileName);
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
