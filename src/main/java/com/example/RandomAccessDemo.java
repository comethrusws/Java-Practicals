package com.example;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;


public class RandomAccessDemo {
    public static void main(String[] args) {
        String fileName = "majdur.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(10);
            raf.writeUTF("bandhuwa majduri is the new communist leader"); 
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
        } catch (IOException e) {
            System.err.println("error occurred while reading from the file: " + e.getMessage());
        }

    }
}
