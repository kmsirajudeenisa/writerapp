package com.writer;

public class StringWriterEvent implements WriterFactory {
    private static StringBuilder stringWriterData = new StringBuilder();

    @Override
    public void writer(String text, boolean appendFlag) {
        stringWriterData.append(text);
        stringWriterData.append("\n");
        this.setStringWriterData(stringWriterData);
        System.out.println("String write text" + text.toString());
    }

    @Override
    public String reader() {
        return getStringWriterData().toString();
    }

    public static StringBuilder getStringWriterData() {
        return stringWriterData;
    }

    public void setStringWriterData(StringBuilder stringWriterData) {
        this.stringWriterData=stringWriterData;
    }
}
