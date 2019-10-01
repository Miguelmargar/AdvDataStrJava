package advDataStrJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exercise2 {

	public static void main(String[] args) {
		Q();

	}
	public static void Q() {
		Queue<Integer> myQ = new LinkedList<Integer>();
		
		Scanner input = new Scanner(System.in);
		
		int number = 0;
		boolean con = true;
		
		while (con) {
			
			System.out.print("Enter an operation (1add, 2remove, 3print, 0exit): ");
			int op = input.nextInt();
			if (op == 1) {
				System.out.print("Enter number to manipulate: ");
				number = input.nextInt();
			}
			
			
			if (op == 1) myQ.add(number);
			else if (op == 2) myQ.remove();
			else if ( op == 3) {
				int elem = myQ.element();
				System.out.println(elem);
			} 
			else if (op == 0) con = false;
		}
		input.close();
	}
}
