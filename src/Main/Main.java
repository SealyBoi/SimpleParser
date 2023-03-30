package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		// Lexical Analysis
		Lexer lex = new Lexer();
		ArrayList<Type> lexResult = lex.lex(input);
		
		// Parser
		Parser parse = new Parser();
		ArrayList<Token> parseResult = parse.parse(lexResult);
		
		printTree(parseResult, 0);
	}
	
	static int depth = 0;
	
	public static void printTree(ArrayList<Token> res, int index) {
		Token tok = res.get(index);
		String str = "";
		for (int i = 0; i < depth; i++) {
			str += "  ";
		}
		if (tok.ty == Token.Ty.NUM) {
			System.out.println(str + tok.ty + "()");
		} else if (tok.ty == Token.Ty.CALLEXP) {
			depth++;
			System.out.println(str + tok.ty + "(");
			for (int i = 0; i < tok.params.size(); i++) {
				printTree(tok.params, i);
			}
			depth--;
			System.out.println(str + ")");
		}
	}
	
}
