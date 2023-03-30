package Main;

import java.util.ArrayList;

public class Parser {
	private int curr = 0;
	ArrayList<Type> types = new ArrayList<Type>();
	Type typ;
	ArrayList<Token> toks = new ArrayList<Token>();
	
	public ArrayList<Token> parse(ArrayList<Type> types) {
		this.types = types;
		typ = this.types.get(curr);
		while (curr < types.size()) {
			toks.add(parse());
			curr++;
		}
		return toks;
	}
	
	private Token parse() {
		if (typ.ty == Type.Ty.INT) {
			return new Token(Token.Ty.NUM, typ.val);
		} else if (typ.ty == Type.Ty.LPAREN) {
			curr++;
			typ = types.get(curr);
			Token callExp = new Token(Token.Ty.CALLEXP, typ.val);
			curr++;
			typ = types.get(curr);
			while (typ.ty != Type.Ty.RPAREN) {
				callExp.push(parse());
				curr++;
				typ = types.get(curr);
			}
			return callExp;
			
		} else {
			throw new Error("Token not found for type: " + typ.ty);
		}
	}
}
