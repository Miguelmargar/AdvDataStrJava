package exercises;
import implementations.*;
import queue.*;
import stack.*;

public class Main {

	public static void main(String[] args) {
		String a = "ana";
		pallindromeStack(a);
		pallindromeListStack(a);
	}

	public static void pallindromeStack(String a) {
		StringBuilder check = new StringBuilder();
		
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			stack.push(b);
		}
		while (!stack.isEmpty()) {
			check.append(stack.pop());
		}
		if (a.equals(check.toString())) System.out.println("PALLINDROME");
		else System.out.println("NOT pallindrome");
	}
	
	public static void pallindromeListStack(String a) {
		StringBuilder check = new StringBuilder();
		
		LinkedStack<Character> linkedList = new LinkedStack<Character>();
		
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			linkedList.push(b);
		}
		while (!linkedList.isEmpty()) {
			check.append(linkedList.pop());
		}
		if (a.equals(check.toString())) System.out.println("PALLINDROME");
		else System.out.println("NOT pallindrome");
	}
}
