package advDataStrJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class exercise1 {

	public static void main(String[] args) {
		String a = "ana";
		pallindromeStack(a);
		pallindromeQueue(a);
	}
	
	public static void pallindromeStack(String a) {
		StringBuilder check = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			stack.push(b);
		}
		
		while (!stack.isEmpty()) {
			check.append(stack.pop());
		}	
		
		if (a.equals(check.toString())) System.out.println("It is a palindrome");
		else System.out.println("Not a pallindrome");
	}
	
	public static void pallindromeQueue(String a) {
		Queue<String> myQ = new LinkedList<String>();
		
		for (int i = a.length()-1; i >= 0; i--) {
			Character ele = a.charAt(i);
			myQ.add(ele.toString());
		}
		int count = 0;
		int i = 0;
		while (!myQ.isEmpty()) {
			String q = myQ.element();
			myQ.remove();
			Character s = a.charAt(i);
			String f = s.toString();
			i++;

			if(!q.equals(f)) count++;
		}
		if (count == 0) System.out.println("It is a palindrome");
		else System.out.println("Not a pallindrome");
	}
	
}
