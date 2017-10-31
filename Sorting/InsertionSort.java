import java.util.Arrays;

/**
 * Created by Senapathi on 31-10-2017.
 * Recursive solution for Insertion Sort implementation
 * The goal is to pick a index and insert it into already sorted array.
 * Because we are dealing with static arrays, the time complexity is O(n*n)
 * Where O(n) is taken to iterate through all elements and other n is for the swap& compare operations.
 * Swap and compare may increases linearly in worst case when smallest element is in the last index we have to shift
 * all the elements to the left.
 */
public class InsertionSort {

    public static void main(String args[]) {


        InsertionSort obj = new InsertionSort();

        int arr[] = {1, 3, 4, 2, 5, 6, 82, 13};

        obj.insertionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }

    private void insertionSort(int[] arr, int n) {


        if (n <= 1) return; // The base condition for recursion


        else insertionSort(arr, n - 1);

        // Here n-2, n-1 represent penultimate, ultimate indexes respectively
        while (n - 2 >= 0 && arr[n - 1] < arr[n - 2]) {

            // Swap operations
            int temp = arr[n - 1];
            arr[n - 1] = arr[n - 2];
            arr[n - 2] = temp;

            // We then compare the element till the last index
            n--;


        }


    }


}
