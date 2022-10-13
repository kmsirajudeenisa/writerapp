package com.writer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WriterService {

    public static void main(String[] args) throws IOException {
        Scanner initialOptionSelection = new Scanner(System.in);
        Scanner inputData = null;
        String option = "";
        File file = new File(WriterConstants.FILENAME);
        while (true) {
            System.out.print("#########################################" +
                    "\n Please select below option \n " +
                    "\n Press 1 to write data to Stringwriter: " +
                    "\n Type 'exit' and enter for abort \n" +
                    "\n Press 2 to Read the stringwriter data in LowerCase:" +
                    "\n Press 3 to Read the stringwriter data in UpperCase:" +
                    "\n Press 4 to remove duplicate text from stringwriter: " +
                    "\n Press 5 to remove specific text from stringwriter: \n " +

                    "\n Press 6 to write data to Filewriter: " +
                    "\n Type 'exit' and enter for abort \n" +
                    "\n Press 7 to Read the Filewriter data in lowerCase:" +
                    "\n Press 8 to Read the Filewriter data in upperCase: " +
                    "\n Press 9 to remove duplicate text from filewriter: " +
                    "\n Press 10 to remove specific text from filewriter: \n " +

                    "\n Type 'exit' and enter for abort \n" +
                    "###################################### \n");
            option = initialOptionSelection.nextLine();
            if (option.equals("exit")) {
                break;
            }
            switch (option) {
                case "1":
                    System.out.println("Please type and enter for keep writing data to string.." +
                            "\n Type 'exit' and ENTER for aborting the writing");
                    inputData = new Scanner(System.in);
                    String stringMessage = "";
                    while (true) {
                        stringMessage = inputData.nextLine();
                        System.out.println(stringMessage);
                        if (stringMessage.equals("exit")) {
                            break;
                        }
                        StringWriterEvent stringWriterEvent = new StringWriterEvent();
                        stringWriterEvent.writer(stringMessage, false);
                    }
                    break;
                case "2":
                    StringWriterEvent stringWriterEvent = new StringWriterEvent();
                    stringWriterEvent.reader();
                    System.out.println("Printing stringwriter lower case: " +
                            stringWriterEvent.reader().toLowerCase());
                    break;
                case "3":
                    StringWriterEvent stringWriter = new StringWriterEvent();
                    System.out.println("Printing stringwriter upper case: " +
                            stringWriter.reader().toUpperCase());
                    break;

                case "4":
                    StringWriterEvent writerEvent = new StringWriterEvent();
                    System.out.println(
                            CommonUtil.removeDuplicateForString(
                                    writerEvent.reader()));
                    break;
                case "5":
                    System.out.println("Please type the remover text and enter.." +
                            "\n Type 'exit' and ENTER for aborting the writing");
                    inputData = new Scanner(System.in);
                    String removerText = "";
                    while (true) {
                        removerText = inputData.nextLine();
                        if (removerText.equals("exit")) {
                            break;
                        }
                        StringWriterEvent writerRemoveElement = new StringWriterEvent();
                        System.out.println(CommonUtil.removeElementFromString(writerRemoveElement.reader(), removerText));
                    }
                    break;
                case "6":
                    System.out.println("Please type and enter for keep writing data to file.." +
                            "\n Type 'exit' and ENTER for aborting the writing");
                    inputData = new Scanner(System.in);
                    String message = "";
                    while (true) {
                        message = inputData.nextLine();
                        if (message.equals("exit")) {
                            break;
                        }
                        FileWriterEvent f = new FileWriterEvent();
                        f.writer(message, true);
                    }
                    break;
                case "7":
                    System.out.println("thanks for invoking lowerCase file reading option");
                    CommonUtil.covertTextCase(false);
                    break;
                case "8":
                    System.out.println("thanks for invoking upperCase file reading option");
                    CommonUtil.covertTextCase(true);
                    break;
                case "9":
                    CommonUtil.removeDuplicateForFile();
                    break;
                case "10":
                    System.out.println("Please type the remover text (from file) and enter.." +
                            "\n Type 'exit' and ENTER for aborting the writing");
                    inputData = new Scanner(System.in);
                    String removerFileText = "";
                    while (true) {
                        removerFileText = inputData.nextLine();
                        if (removerFileText.equals("exit")) {
                            break;
                        }
                        StringBuffer sBuffer = new StringBuffer();
                        //File file = new File(WriterConstants.FILENAME);
                        Scanner input = new Scanner(file);
                        while (input.hasNext()) {
                            String next = input.next();
                            sBuffer.append(next);
                            sBuffer.append(" ");
                        }
                        System.out.println(CommonUtil.removeElementFromString(sBuffer.toString(), removerFileText));
                    }
                    break;

                default:
                    System.out.println("default");
                    initialOptionSelection.close();
                    break;
            }
        }
    }
}
