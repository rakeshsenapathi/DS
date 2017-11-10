import java.util.Arrays;

/**
 * Created by Senapathi on 10-11-2017.
 * Radix Sort uses Couting Sort as a sub routine to improve it.
 * We iterate count sort digit wise i.e take 1st digit of each number initially and countsort it.
 * Do it until all digits are iterated. The result is a sorted array.
 * We know that CountingSort takes O(n+k) time, where is k is range of keys/elements.
 * In RadixSort the range is representation of our number( In this implementation base = 10) in a certain base b.
 * So TimeComplexity becomes O(n + b) since here k = b;
 * We are also iterating CountSort based on the number of digits d.
 * So finally, Time Complexity of Radix Sort is O(d*(n+b)).
 */
public class RadixSort {


    public static void main(String args[]) {

        RadixSort obj = new RadixSort();

        int[] arr = new int[]{20, 18, 38, 218, 113, 273};

        obj.doRadixSort(arr);

        System.out.println(Arrays.toString(arr));


    }

    private void doRadixSort(int[] arr) {

        int max_val = getMax(arr);


        for (int digit = 1; max_val / digit > 0; digit *= 10) {

            countSort(arr, digit);

        }


    }

    private void countSort(int[] arr, int digit) {

        int length = arr.length;


        int range = 10;

        // The sorted array which is being return by the function
        int[] axillary = new int[length];

        // Stores the frequency of a number.
        int[] count = new int[range];

        // Initialise all the indices in the count array to 0.
        for (int i = 0; i < range; i++) {

            count[i] = 0;

        }

        // Iterate through the array to update the frequencies.
        for (int i = 0; i < arr.length; i++) {

            count[(arr[i] / digit) % 10]++;

        }

        /* Leaving the first element, value from previous index is added to give the starting position.
        *  Consider input : {1, 2, 3, 2, 4, 5, 6}
        *  After updating the frequencies, the count array will look like {0,1,2,1,1,1,1}
        *  Now to know the starting point of an element to populate we must change the count array.
        *  The next loop changes the count array.
        * */
        for (int i = 1; i < range; i++) {


            count[i] = count[i] + count[i - 1];

        }

        // Count array gives the guideline about where to insert
        // We move from end of the array to left to preserve the stable sort property.
        for (int i = length - 1; i >= 0; i--) {

            axillary[count[(arr[i] / digit) % 10] - 1] = arr[i];

            count[(arr[i] / digit) % 10]--;

        }

        System.arraycopy(axillary, 0, arr, 0, length);


    }

    private int getMax(int[] arr) {

        int max_val = arr[0];

        for (int anArr : arr) {

            if (max_val < anArr) max_val = anArr;

        }

        return max_val;

    }

}
