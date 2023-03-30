package Main;

public class Type {
	public static enum Ty {LPAREN, RPAREN, IDENT, INT};
	
	Ty ty;
	String val;
	
	public Type (Ty type, String val){
		this.ty = type;
		this.val = val;
	}
}
