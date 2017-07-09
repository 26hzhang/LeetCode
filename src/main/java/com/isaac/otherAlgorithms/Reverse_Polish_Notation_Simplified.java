package com.isaac.otherAlgorithms;

import java.util.Stack;

/**
 * Question:
 * 逆波兰式（Reverse Polish Notation，RPN，或逆波兰记法），也叫后缀表达式（将运算符写在操作数之后）
 * 定义：
 * 一个表达式E的后缀形式可以如下定义：
 * （1）如果E是一个变量或常量，则E的后缀式是E本身。
 * （2）如果E是E1 op E2形式的表达式，这里op是如何二元操作符，则E的后缀式为E1'E2' op，这里E1'和E2'分别为E1和E2的后缀式。
 * （3)如果E是（E1）形式的表达式，则E1的后缀式就是E的后缀式。
 * 如：我们平时写a+b，这是中缀表达式，写成后缀表达式就是：ab+
 * (a+b)*c-(a+b)/e的后缀表达式为：
 * (a+b)*c-(a+b)/e
 * →((a+b)*c)((a+b)/e)-
 * →((a+b)c*)((a+b)e/)-
 * →(ab+c*)(ab+e/)-
 * →ab+c*ab+e/-
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 将一个普通的中序表达式转换为逆波兰表达式的一般算法是：
 *        首先需要分配2个栈，一个作为临时存储运算符的栈S1（含一个结束符号），一个作为输入逆波兰式的栈S2（空栈），
 *        S1栈可先放入优先级最低的运算符#，注意，中缀式应以此最低优先级的运算符结束。可指定其他字符，不一定非#不可。
 *        从中缀式的左端开始取字符，逐序进行如下步骤：
 *        （1）若取出的字符是操作数，则分析出完整的运算数，该操作数直接送入S2栈
 *        （2）若取出的字符是运算符，则将该运算符与S1栈栈顶元素比较，如果该运算符优先级大于S1栈栈顶运算符优先级，
 *        则将该运算符进S1栈，否则，将S1栈的栈顶运算符弹出，送入S2栈中，直至S1栈栈顶运算符低于（不包括等于）
 *        该运算符优先级，最后将该运算符送入S1栈。
 *        （3）若取出的字符是“（”，则直接送入S1栈顶。
 *        （4）若取出的字符是“）”，则将距离S1栈栈顶最近的“（”之间的运算符，逐个出栈，依次送入S2栈，此时抛弃“（”。
 *        （5）重复上面的1~4步，直至处理完所有的输入字符
 *        （6）若取出的字符是“#”，则将S1栈内所有运算符（不包括“#”），逐个出栈，依次送入S2栈。
 */
public class Reverse_Polish_Notation_Simplified {

	public static void main(String[] args) {
		String str = "11+22-5*(5-4)*6-(6-1)";
		Stack<String> stack = expression(str);
		System.out.println(stack.toString());
		double answer = compute(stack);
		System.out.println(answer);
	}

	// 只考虑加减乘除和括号，不考虑单目运算符e.g. -
	public static Stack<String> expression(String str) {
		char[] arr = str.toCharArray();
		Stack<String> stack = new Stack<String>();
		Stack<String> temp = new Stack<String>();
		int i = 0;
		while (i < arr.length) {
			switch (arr[i]) {
			case ('('):
				temp.push(String.valueOf(arr[i]));
				break;
			case (')'):
				while (!temp.peek().equals("("))
					stack.push(temp.pop());
				temp.pop();
				break;
			case ('+'):
			case ('-'):
				while (!temp.isEmpty() && !temp.peek().equals("("))
					stack.push(temp.pop());
				temp.push(String.valueOf(arr[i]));
				break;
			case ('*'):
			case ('/'):
				while (temp.peek().equals("*") || temp.peek().equals("/"))
					stack.push(temp.pop());
				temp.push(String.valueOf(arr[i]));
				break;
			default:
				String s = "";
				while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
					s += String.valueOf(arr[i]);
					i++;
				}
				stack.push(s);
				i--;
			}
			i++;
		}
		while (!temp.isEmpty())
			stack.push(temp.pop());
		return stack;
	}

	// 对应的逆波兰式求值方法
	public static double compute(Stack<String> stack) {
		Stack<String> temp = new Stack<String>();
		while (!stack.isEmpty())
			temp.push(stack.pop());
		Stack<Double> ans = new Stack<Double>();
		while (!temp.isEmpty()) {
			String s = temp.pop();
			if (s.equals("+")) {
				ans.push(ans.pop() + ans.pop());
			} else if (s.equals("-")) {
				double d1 = ans.pop(), d2 = ans.pop();
				ans.push(d2 - d1);
			} else if (s.equals("*")) {
				ans.push(ans.pop() * ans.pop());
			} else if (s.equals("/")) {
				double d1 = ans.pop(), d2 = ans.pop();
				ans.push(d2 / d1);
			} else {
				ans.push(Double.parseDouble(s));
			}
		}
		return ans.pop();
	}

}
