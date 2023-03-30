package Main;

import java.util.ArrayList;

public class Token {
	public static enum Ty {CALLEXP, NUM};
	
	Ty ty;
	String val;
	ArrayList<Token> params = new ArrayList<Token>();
	
	public Token (Ty ty, String val) {
		this.ty = ty;
		this.val = val;
	}
	
	public void push(Token tok) {
		params.add(tok);
	}

}
