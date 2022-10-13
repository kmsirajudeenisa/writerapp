package com.writer;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CommonUtil {
    public static void covertTextCase(boolean upperCaseFlag) {

        try {
            FileReader reader = new FileReader(WriterConstants.FILENAME);
            String result = "";
            int data;
            int data2;

            while ((data = reader.read()) != -1) {
                if (upperCaseFlag) {
                    data2 = Character.toUpperCase(data);
                } else {
                    data2 = Character.toLowerCase(data);
                }
                result += (char) data2;
            }
            reader.close();
            System.out.println(result);
            FileWriter writer = new FileWriter("e.txt");
            writer.write(result);
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeDuplicateForFile() {
        HashSet<String> lines = new LinkedHashSet<>();
        File file = new File(WriterConstants.FILENAME);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext()) {
            String next = input.next();
            lines.add(next);
        }
        input.close();
        FileWriterEvent f = new FileWriterEvent();
        int writeCount = 0;
        for (String line : lines) {
            System.out.println(line);
            if (writeCount == 0) {
                f.writer(line, false);
                writeCount++;
            } else {
                f.writer(line, true);
            }
        }
    }

    public static String removeDuplicateForString(String input) {
        HashSet<String> stringHashSet = new LinkedHashSet<>(input.length() - 1);
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = input.split("\\s+");
        for (String str : strArr)
            stringHashSet.add(str);

        for (String str : stringHashSet) {
            stringBuffer.append(str);
            stringBuffer.append(" ");
        }

        return stringBuffer.toString();
    }

    public static String removeElementFromString(String input, String removeText) {
        String msg[] = input.split(" ");
        String new_str = "";
        for (String words : msg) {
            if (!words.trim().equals(removeText)) {
                new_str += words + " ";
            }
        }
        return new_str;
    }
}
