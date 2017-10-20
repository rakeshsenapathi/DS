import java.util.Stack;

/**
 * Created by Senapathi on 20-10-2017.
 * Implementation of Infix to Postfix conversion.
 */
public class InfixToPostfix {


    private String convertToPostfix(String expression) {

        Stack<Character> operators = new Stack<>(); //Stack to hold all the operators

        String result = "";


        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (isOperand(ch)) {

                result = result + ch; //If operand, add it to the result

            } else if (isOperation(ch)) {

                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), ch) && !isOpeningParenthesis(ch)) {
                    // If the stack is not empty and top of stack has higher precedence than "ch".

                    result = result + operators.peek();

                    operators.pop();


                }

                operators.push(ch);


            }
            // Following 2 conditions are to check for bracket precedence.
            else if (isOpeningParenthesis(ch)) {

                operators.push(ch);
            } else if (isClosingParenthesis(ch)) {


                while (!operators.isEmpty() && !isOpeningParenthesis(operators.peek())) {

                    result = result + operators.peek();

                    operators.pop();


                }

                operators.pop(); //Pop the closing bracket.


            }


        }

        while (!operators.empty()) {

            result = result + operators.peek();
            operators.pop();
        }

        return result;


    }

    private boolean isClosingParenthesis(char ch) {
        return ch == ']' || ch == '}' || ch == ')';
    }

    private boolean isOpeningParenthesis(char ch) {

        return ch == '[' || ch == '{' || ch == '(';
    }

    private boolean hasHigherPrecedence(Character peek, char ch) {


        if (peek == '*' || peek == '/') {

            return ch == '+' || ch == '-';

        } else return false;


    }


    private boolean isOperation(char ch) {


        if (ch == '*' || ch == '/' || ch == '+' || ch == '-') return true;
        else return false;


    }

    private boolean isOperand(char ch) {

        return ch >= '0' && ch <= '9';

    }


    public static void main(String args[]) {


        InfixToPostfix infixToPostfix = new InfixToPostfix();

        String result = infixToPostfix.convertToPostfix("((5*4) + (6*2))");

        System.out.println(result);


    }


}
