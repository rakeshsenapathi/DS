import java.util.Arrays;

/**
 * Created by Senapathi on 04-11-2017.
 * build_maxHeap will take O(n) time complexity, max_heapify takes O(logn)
 * Heap Sort approaches the following way.
 * 1. Build MapHeap.
 * 2. Extract Max element(Swap first element(max element) to the value in last index).
 * 3. Since Heap now violates MaxHeap max_heapify() is invoked.
 * 4. Repeat until index = 0
 */
public class HeapSorting {


    public static void main(String args[]) {


        int[] arr = new int[]{5, 3, 6, 4, 8, 9, 10};

        doHeapSort(arr);

        System.out.println(Arrays.toString(arr));


    }

    private static void doHeapSort(int[] arr) {

        // Build a MaxHeap
        build_mapHeap(arr, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {

            // Extract the max element
            int temp = arr[0];

            arr[0] = arr[i];

            arr[i] = temp;
            //

            // Now we are excluding the sorted value i.e max_value and sending rest of the array.
            max_heapify(arr, 1, i);

        }

    }

    private static void build_mapHeap(int[] arr, int heapsize) {

        if (heapsize == 0) {

            System.out.println("Empty Array");

        }


        for (int i = arr.length / 2; i >= 1; i--) {

            max_heapify(arr, i, heapsize);

        }


    }

    private static void max_heapify(int[] arr, int index, int heapsize) {

        //This function is called recursively until max_value is found.

        int left_index = 2 * index;

        int right_index = left_index + 1;

        int largest = index; // Initially index is the largerst

        if (left_index <= heapsize && arr[left_index - 1] > arr[largest - 1]) {

            largest = left_index;

        }

        if (right_index <= heapsize && arr[right_index - 1] > arr[largest - 1]) {

            largest = right_index;

        }

        if (largest != index) {

            int temp = arr[index - 1];

            arr[index - 1] = arr[largest - 1];

            arr[largest - 1] = temp;
            
            max_heapify(arr, largest, heapsize);


        }


    }


}
