
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Senapathi on 18-10-2017.
 */
public class PostfixStack {


    private int EvaluatePostFix(String postfixExp) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < postfixExp.length(); i++) {

            if (postfixExp.charAt(i) == ' ' || postfixExp.charAt(i) == ',') continue;

            else if (isExpression(postfixExp.charAt(i))) {


                int operand2 = stack.peek();
                stack.pop();

                int operand1 = stack.peek();
                stack.pop();

                int result = doOperation(postfixExp.charAt(i), operand1, operand2);

                stack.push(result);

            } else if (isNumeric(postfixExp.charAt(i))) {
                
                stack.push(Character.getNumericValue(postfixExp.charAt(i)));


            }


        }

        return stack.peek(); // returns the final result, which will be only one element i.e top

    }

    private boolean isNumeric(char c) {

        if (c >= '0' && c <= '9') return true;
        else return false;

    }

    private int doOperation(char operation, int operand2, int operand1) {

        if (operation == '+') return operand1 + operand2;

        else if (operation == '/') return operand1 / operand2;

        else if (operation == '-') return operand1 - operand2;

        else if (operation == '*') return operand1 * operand2;

        else {
            System.out.println("Error while doing operations");
            return -1;
        }


    }

    private boolean isExpression(char c) {

        if (c == '*' || c == '/' || c == '+' || c == '-') return true;
        else return false;

    }

    public static void main(String args[]) {

        PostfixStack postfixStack = new PostfixStack();

        Scanner sc = new Scanner(System.in);

        int result = postfixStack.EvaluatePostFix(sc.nextLine());

        System.out.println(result);


    }


}
