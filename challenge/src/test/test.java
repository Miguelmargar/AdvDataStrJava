package test;

public class test {

	public static void main(String[] args) {
		String s = " aa- bbc12316";
		
		StringBuilder joined = new StringBuilder("");
		StringBuilder separate = new StringBuilder("");
		
		String ex = " ";
		String dash = "-";
		
        for (int i = 0; i < s.length(); i++) {      	
            if (s.charAt(i) == ex.charAt(0) || s.charAt(i) == dash.charAt(0)) continue; 
            	
            else joined.append(s.charAt(i));
        }
        
        
        for (int i = 0; i < joined.length(); i++) {
        	if (i == 0) separate.append(joined.charAt(i));
        	
        	if (i != 0 && i % 3 != 0) 
        		separate.append(joined.charAt(i));
        	
        	else if (i != 0 && i % 3 == 0) {
        		separate.append(" " + joined.charAt(i));     	
        	}
        }
        
        if (separate.charAt(separate.length()-2) == ex.charAt(0)) {
        	String b =  separate.toString();
        	Character c = b.charAt(b.length()-3);
            int len = separate.length();
        	separate.replace(len-2, len-1, c.toString());
        	separate.replace(len-3, len-2, " ");
        }
        	
        	
        	
        
		
		System.out.println(separate);

	}
	
	
	
}
