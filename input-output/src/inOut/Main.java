package inOut;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	createFile();
    }

    public static void createFile() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Output file name: ");
        String outputFileName = console.next();
        System.out.print("How many lines to add? ");
        int lines = Integer.parseInt(console.next());
        System.out.print("Number of lines input: " + lines + "\n");

        PrintWriter out = new PrintWriter(outputFileName);

        for (int i = 0; i < lines; i++) {
            System.out.print("Write for line number " + (i + 1) + ": ");
            String lineInput = console.next();
            out.println(lineInput);
        }
        out.close();

        System.out.println();
        System.out.println("Now print the file contents---------");
        System.out.println();

        System.out.print("Input file to read from? ");
        String inputFileName = console.next();
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner((inputFile));

//        Prints each character in a new line
//        in.useDelimiter("");
//        while (in.hasNext()) {
//            char ch = in.next().charAt(0);
//            System.out.println(ch);
//        }

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

    }

}
