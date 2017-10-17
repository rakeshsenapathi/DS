import java.util.NoSuchElementException;
import java.util.*;
/**
 * Created by Senapathi on 07-09-2017.
 * Implementation of stack data structure using arrays.
 * Size of the array is taken from user input.
 * All the operations like push() and pop() grow at constant time O(1)
 */
class StackImplement {

    private int arr[];
    private int len, top, size;


    private StackImplement(int n){

        size = n;
        top = -1;
        arr = new int[size];
        len=0;

    }


    private boolean isEmpty(){

        return top == -1;

    }

    private boolean isFull(){

        return top == size-1;
    }

    private int getSize(){

        return len;
    }

    private void push(int i){

        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    private int pop(){

        if(isEmpty()){
            throw new NoSuchElementException("UnderFlow Exception");
        }
        len-- ;
        return arr[top--];
    }

    private void display() {

        System.out.println("\n Stack = ");
        if (len == 0) {
            System.out.println("Empty \n");
            return;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Stack Test\n");
        System.out.println("Enter Size of Integer Stack ");
        int n = sc.nextInt();
        /* Creating object of class arrayStack */
        StackImplement stack = new StackImplement(n);
        /* Perform Stack Operations */
        char ch;
        do{
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. size");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to push");
                    try
                    {
                        stack.push(sc.nextInt());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 2 :
                    try
                    {
                        System.out.println("Popped Element = " + stack.pop( ));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 3 :
                    System.out.println("Empty status = " + stack.isEmpty());
                    break;
                case 4 :
                    System.out.println("Full status = " + stack.isFull());
                    break;
                case 5 :
                    System.out.println("Size = " + stack.getSize());
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /* display stack */
            stack.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);

        } while (ch == 'Y'|| ch == 'y');
    }



}
