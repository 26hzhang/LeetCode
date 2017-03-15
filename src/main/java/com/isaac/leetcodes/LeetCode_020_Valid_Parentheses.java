package com.isaac.leetcodes;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "() []{}" are all
 * valid but "()" and "([])" are not.
 *
 * Tags: Stack, String.
 *
 * @author ZHANG HAO
 *
 *         Explain: 利用栈进行匹配，遇到'(', '{', '['入栈，遇到']', '}' and ')'则出栈对应的'(',
 *         '{'或'['，如果匹配，则出栈，直到栈空，返回true。如果不匹配，则返回false。
 *         改进：代码中的繁琐的比较可以改为用括号间的ASCII码差来解决。
 *         ‘(’：40，‘)’：41；
 *         ‘[’：107，‘]’：109；
 *         ‘{’：123，‘}’：125。
 *
 *
 */
public class LeetCode_020_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else {
				if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'))
					return false;
				else {
					char chr = stack.pop();
					if (s.charAt(i) == ')' && chr != '(')
						return false;
					if (s.charAt(i) == ']' && chr != '[')
						return false;
					if (s.charAt(i) == '}' && chr != '{')
						return false;
				}
			}
			i++;
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}

	// or using hashMap
	public boolean isValid2(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		char[] sArr = s.toCharArray();
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put(')', '(');
		hm.put('}', '{');
		hm.put(']', '[');
		Stack<Character> st = new Stack<Character>();
		for (char c : sArr) {
			if (!hm.containsKey(c)) {
				st.push(c);
			} else {
				if (st.isEmpty() || st.pop() != hm.get(c)) {
					return false;
				}
			}
		}
		return st.isEmpty();
	}

	// modified the first method
	public static boolean isValid3(String s) {
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else {
				if (!stack.isEmpty()) {
					char chr = stack.pop();
					if (s.charAt(i) > chr && (s.charAt(i) - chr) <= 2)
						continue;
					else
						return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
