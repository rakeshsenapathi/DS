import java.util.Arrays;

/**
 * Created by Senapathi on 09-11-2017.
 * We can manipulate Counting Model to achieve almost linear time while sorting.
 * Counting Sort gives Time Complexity of O(n + k) , where k is the range of values.
 * We assume that the set is of integer values within a range of k.
 * Stable Sorting : If duplicate values are present it is important to preserve the order of occurence of elements.
 */
public class CountingSort {

    public static void main(String args[]) {

        int[] array = new int[]{1, 2, 3, 2, 4, 5, 6};

        CountingSort obj = new CountingSort();

        int[] sorted_array = obj.countSort(array);

        System.out.println(Arrays.toString(sorted_array));
    }

    private int[] countSort(int[] array) {


        // The sorted array which is being return by the function
        int[] axillary = new int[array.length + 1];

        // Stores the frequency of a number.
        int[] count = new int[array.length + 1];


        // Initialise all the indices in the count array to 0.
        for (int element : array) {

            count[array[element]] = 0;

        }

        // Iterate through the array to update the frequencies.
        for (int anArray : array) {

            count[anArray]++;

        }

        /* Leaving the first element, value from previous index is added to give the starting position.
        *  Consider input : {1, 2, 3, 2, 4, 5, 6}
        *  After updating the frequencies, the count array will look like {0,1,2,1,1,1,1}
        *  Now to know the starting point of an element to populate we must change the count array.
        *  The next loop changes the count array.
        * */

        for (int i = 1; i < array.length; i++) { // We are excluding the index 0 since it is in place.

            count[i] = count[i] + count[i - 1];
            // By adding the value from previous index the count array looks like { 0 , 1, 3, 4, 5, 6, 7}


        }

        // Count array gives the guideline about where to insert
        // We move from end of the array to left to preserve the stable sort property.
        for (int i = array.length - 1; i >= 0; i--) {

            axillary[count[array[i]]] = array[i];
            count[array[i]]--;

        }

        return axillary;

    }


}
