package Question;

import java.util.Stack;

public class Conversion {
    public static void main(String[] args) {
        System.out.println(inFixToPostFix("a+b*(c^d-e)"));
        System.out.println(inFixToPrefix("a+b*(c^d-e)"));
        System.out.println(PostFixToInfix(inFixToPostFix("a+b*(c^d-e)")));
    }

    public static String inFixToPostFix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    if (ch == '^' && stack.peek() == '^') {
                        break;
                    }
                    sb.append(stack.pop());

                }
                stack.push(ch);

            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static String inFixToPrefix(String str) {

        return new StringBuilder(inFixToPostFix(reverse(str))).reverse().toString();

    }
    
    public static String PostFixToInfix(String str){
        Stack<String> stack = new Stack<>();

        for (Character ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch.toString());
            }else {
                String first = stack.pop();
                String second = stack.pop();

                String res = "(" + second + ch + first + ")";
                stack.push(res);
            }
        }

        return stack.peek();
    }




    
    private static String reverse(String str) {
        StringBuilder rev = new StringBuilder();

        for (int index = str.length() - 1; index >= 0; index--) {
            char ch = str.charAt(index);
            if (ch == '(') {
                rev.append(')');
            } else if (ch == ')') {
                rev.append('(');
            } else {
                rev.append(ch);
            }
        }

        return rev.toString();

    }

    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;

            default -> -1;

        };
    }

}
