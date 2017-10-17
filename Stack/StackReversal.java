import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Senapathi on 17-10-2017.
 * Reversing a string using stack.
 */
public class StackReversal {


    private static String word;


    private String doReversal(String word) {

        Stack<Character> stack = new Stack<>();

        String reversed_word = "";

        for (int i = 0; i < word.length(); i++) {

            stack.push(word.charAt(i));

        }

        for (int i = 0; i < word.length(); i++) {

            reversed_word += stack.pop();

        }

        return reversed_word;

    }


    public static void main(String args[]) {

        StackReversal stackReversal = new StackReversal();

        System.out.println("Enter the String to be reversed");

        Scanner sc = new Scanner(System.in);

        System.out.println(stackReversal.doReversal(sc.nextLine()));


    }


}
