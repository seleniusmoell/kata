package main;

public class Wrapper {
	public static String wrap(String s, int col) {
		return new Wrapper(col).wrap(s);
	}
		
	private int col;
	
	private Wrapper(int col) {
		this.col = col;
	}
	
	private String wrap(String s) {
		
		if(s.length() <= col) 		
			return s; 
		
		int space = (s.substring(0, col).lastIndexOf(' ')); 
		if (space != -1)
			return breakline(s, space, 1);
		else if (s.charAt(col) == ' ')
			return breakline(s, col, 1);
		else
			return breakline(s, col, 0);
		
	}
	
	private String breakline(String s, int pos, int gap) {
		return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap), col);
	}
	
}
