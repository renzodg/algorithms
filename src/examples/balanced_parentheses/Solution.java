package examples.balanced_parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		String expression = "{}";
		boolean result = isBalanced(expression);
		System.out.println(result);
	}
	
	private static char[][] TOKENS = { {'{','}'}, {'[', ']'}, {'(',')'} };
	
	
	public static boolean isBalanced(String expression) {
		Stack<Character> openTerms = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			if (isOpenTerm(c)) {
				openTerms.push(c);
			} else {
				if (openTerms.isEmpty() || !matches(openTerms.pop(), c)) {
					return false;
				}
			}
		}
		
		return openTerms.isEmpty();
	}


	private static boolean matches(char openTerm, char closeTerm) {
		for (char[] token : TOKENS) {
			if (token[0] == openTerm && token[1] == closeTerm) {
				return true;
			}
		}
		return false;
	}


	private static boolean isOpenTerm(char c) {
		for (char[] token : TOKENS) {
			if (token[0] == c) {
				return true;
			}
		}
		return false;
	}

}
