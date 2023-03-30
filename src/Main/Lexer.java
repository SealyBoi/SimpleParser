package Main;

import java.util.ArrayList;

public class Lexer {
	private int index = 0;
	private char[] ch;
	private int depth = 0;
	
	public ArrayList<Type> lex(String input) {
		ch = input.toCharArray();
		ArrayList<Type> tyArr = new ArrayList<Type>();
		while (index < ch.length) {
			Type ret = lex();
			if (ret != null) {
				tyArr.add(ret);
			}
			index++;
		}
		if (depth <= 0) {
			return tyArr;
		} else {
			throw new Error("Incomplete statement, depth: " + depth);
		}
	}
	
	public Type lex() {
		if (Character.isWhitespace(ch[index])) {
			return null;
		} else if (ch[index] == '(') {
			depth++;
			return new Type(Type.Ty.LPAREN, "" + ch[index]);
		} else if (ch[index] == ')') {
			depth--;
			return new Type(Type.Ty.RPAREN, "" + ch[index]);
		} else if (Character.isDigit(ch[index])) {
			return new Type(Type.Ty.INT, "" + ch[index]);
		} else {
			String val = "";
			while (!Character.isWhitespace(ch[index])) {
				val += ch[index];
				index++;
			}
			return new Type(Type.Ty.IDENT, val);
		}
	}
}
