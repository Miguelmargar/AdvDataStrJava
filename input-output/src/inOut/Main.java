package inOut;

import javax.swing.*;
import java.io.*;
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

//        File Dialog Box - shows up - this is instead of asking user to type
//        file name as per below - if using this, need to change 'in' in try
//        catch block too

//        JFileChooser chooser = new JFileChooser();
//        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = chooser.getSelectedFile();
//            Scanner in = new Scanner(selectedFile);
//        }

        System.out.print("Input file to read from? ");
        String inputFileName = console.next();

        try {
            Scanner in = new Scanner(new File(inputFileName));

//        Prints each character in a new line - instead of each line as per below
//        in.useDelimiter("");
//        while (in.hasNext()) {
//            char ch = in.next().charAt(0);
//            System.out.println(ch);
//        }

            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
            in.close();
        }
        catch (IOException exception) {
            System.out.println("File does not exist");
        }
//        Finally should not go together with a catch in same try block - this is just a test
        finally {
            System.out.println("End of program to test 'finally' clause");
        }





    }

}
