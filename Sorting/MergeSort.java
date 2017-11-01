import java.util.Arrays;

/**
 * Created by Senapathi on 31-10-2017.
 * Recursive Solution for merge algorithm
 * Since it is not in-place sorting an additional array space is required which takes Theta(n) space.
 * The recursive equation is 2 T(n/2) + cn where cn is time taken to merge
 * It belongs to Divide and Conquer Paradigm.
 * Time Complexity is Theta(nlogn)
 */
public class MergeSort {


    public static void main(String args[]) {


        MergeSort obj = new MergeSort();

        int arr[] = {1, 3, 4, 2, 5, 6, 82, 13};

        obj.doMergeSort(arr);


        System.out.println(Arrays.toString(arr));

    }

    private void doMergeSort(int[] arr) {

        int count = arr.length;

        if (count < 2) return;

        int mid = count / 2;

        // Temporary arrays for left and right sub arrays
        int[] left_subarr = new int[mid];

        int[] right_subarr = new int[count - mid];


        for (int i = 0; i < count; i++) {

            // Storing values to left subarray
            if (i < mid) {

                left_subarr[i] = arr[i];
            }
            // All the elements after mid index are stored to right subarray.
            else right_subarr[i - mid] = arr[i];


        }

        // Recursive calls
        doMergeSort(left_subarr);
        doMergeSort(right_subarr);
        //

        // This function sorts the array
        helperSort(arr, left_subarr, right_subarr);


    }

    private void helperSort(int[] result, int[] left_subarr, int[] right_subarr) {


        int index1 = 0, index2 = 0;

        for (int i = 0; i < result.length; i++) {

            // If the right sub array is exhausted we have iterate through left sub array
            if (index2 == right_subarr.length) {


                result[i] = left_subarr[index1];
                index1++;


            }
            // When Left sub array is exhausted
            else if (index1 == left_subarr.length) {


                result[i] = right_subarr[index2];
                index2++;

            }
            // Lower values gets added to the result and the respective index is updated.
            else if (left_subarr[index1] < right_subarr[index2]) {


                result[i] = left_subarr[index1];
                index1++;

            } else if (left_subarr[index1] > right_subarr[index2]) {

                result[i] = right_subarr[index2];
                index2++;


            }

        }

    }


}
