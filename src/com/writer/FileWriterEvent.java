package com.writer;

import java.io.PrintWriter;

public class FileWriterEvent implements WriterFactory
{
    @Override
    public void writer(String text, boolean appendFlag) {

        String fileName = "/home/siraj/Desktop/10.txt";

        PrintWriter writer = null;
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(fileName, appendFlag);
            writer = new PrintWriter(fileWriter);
        } catch (Exception e) {
        }
        writer.println(text);
        writer.close();
    }

    @Override
    public String reader() {
        return null;
    }
}
