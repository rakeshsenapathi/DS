import java.util.Stack;

/**
 * Created by Senapathi on 18-10-2017.
 * Implementing stack to check if the parenthesis are balanced.
 */
public class BalancingParenthesis {


    private boolean checkBalancing(String expression) {


        Stack<Character> stack = new Stack<>(); //Creating stack of Character type

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            //To push opening brackets if any into the stack
            if (ch == '{' || ch == '[' || ch == '(') {

                stack.push(ch);

            } else if (ch == '}' || ch == ')' || ch == ']') {

                if (stack.isEmpty() || !isBalancingPair(stack.peek(),ch)) {
                    // If the stack is empty or the top of the stack doesn't match with character

                    return false;

                } else {
                    stack.pop();
                }
            }

        }

        return stack.isEmpty();

    }

    public static void main(String arg[]) {

        BalancingParenthesis obj = new BalancingParenthesis();

        System.out.println(obj.checkBalancing("[}"));


    }


    private boolean isBalancingPair(char top, char ch) {

        if (top == '(' && ch == ')')
            return true;
        else if (top == '{' && ch == '}')
            return true;
        else if (top == '[' && ch == ']')
            return true;
        else
            return false;
    }
}
