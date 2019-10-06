package stack;

public class Main {

	public static void main(String[] args) {
		String a = "anab";
		pallindromeStack(a);
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
}
