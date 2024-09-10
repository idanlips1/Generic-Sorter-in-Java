import java.util.Random;

public class Sorter<T extends Comparable<T>> {

    // QuickSort algorithm entry point
    public static <T extends Comparable<T>> void quickSort(T[] array) {
        // Base case: if the array has less than 2 elements, it's already sorted
        if (array.length < 2) {
            return;
        }
        Quicksort(array, 0, array.length - 1);
    }

    // Recursive QuickSort function
    private static <T extends Comparable<T>> void Quicksort(T[] array, int left, int right) {
        // If the segment to be sorted is larger than 10 elements, use QuickSort
        if (right - left > 10) {
            int pivot = Partition(array, left, right);
            Quicksort(array, left, pivot - 1);
            Quicksort(array, pivot + 1, right);
        } else {
            // For small segments, use BubbleSort for simplicity
            Bubblesort(array, left, right);
        }
    }

    // Partition function for QuickSort
    private static <T extends Comparable<T>> int Partition(T[] array, int left, int right) {
        Random random = new Random();
        int r = random.nextInt(right - left + 1) + left; // Select a random pivot
        swap(array, r, right); // Move pivot to the end
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j); // Swap elements smaller than pivot
            }
        }
        swap(array, i + 1, right); // Place pivot in the correct position
        return i + 1;
    }

    // Swap function to exchange elements in the array
    private static <T> void swap(T[] Array, int i, int j) {
        T temp = Array[i];
        Array[i] = Array[j];
        Array[j] = temp;
    }

    // BubbleSort algorithm for small segments
    private static <T extends Comparable<T>> void Bubblesort(T[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            for (int j = i; j > left; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    swap(array, j - 1, j); // Swap elements if out of order
                }
            }
        }
    }

    // MergeSort algorithm without recursion
    public static <T extends Comparable<T>> void mergeSortNoRecursion(T[] array) {
        if (array.length < 2) {
            return;
        }
        T[] temp = (T[]) new Comparable[array.length];
        // Iteratively split the array into subarrays and merge them
        for (int size = 1; size < array.length; size *= 2) {
            for (int first = 0; first < array.length - size; first += 2 * size) {
                int mid = first + size - 1;
                int last = Math.min(first + 2 * size - 1, array.length - 1);
                Merge(array, temp, first, mid, last);
            }
        }
    }

    // Merge function to combine two sorted subarrays
    public static <T extends Comparable<T>> void Merge(T[] array, T[] temp, int first, int mid, int last) {
        int leftlast = mid;
        int rightfirst = mid + 1;
        int size = last - first + 1;
        int left = first;
        int right = rightfirst;
        int i = first;

        // Merge elements from left and right subarrays into temp
        while (left <= leftlast && right <= last) {
            if (array[left].compareTo(array[right]) <= 0) {
                temp[i] = array[left];
                left++;
            } else {
                temp[i] = array[right];
                right++;
            }
            i++;
        }
        // Copy remaining elements from left subarray
        System.arraycopy(array, left, temp, i, leftlast - left + 1);
        // Copy remaining elements from right subarray
        System.arraycopy(array, right, temp, i, last - right + 1);
        // Copy merged elements back to the original array
        System.arraycopy(temp, first, array, first, size);
    }

    // RadixSort algorithm for sorting an array of Long integers
    public static void radixSort(Long[] array, int bitsPerDigit) {
        if (array.length < 2) {
            return;
        }
        Long max = findMax(array); // Find the maximum element to determine the number of digits
        int numOfDigits = 0;
        int base = 1 << bitsPerDigit; // Calculate the base for the given bits per digit
        while (max > 0) {
            max /= base;
            numOfDigits++;
        }
        // Sort the array for each digit
        for (int i = 0; i < numOfDigits; i++) {
            countingSort(array, bitsPerDigit, i);
        }
    }

    // Helper function to find the maximum element in the array
    public static Long findMax(Long[] array) {
        Long maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    // Extract a specific digit from a key
    private static int extractDigit(Long key, int bitsPerDigit, int digitIndex) {
        return (int) (key >>> bitsPerDigit * digitIndex) & ((1 << bitsPerDigit) - 1);
    }

    // CountingSort algorithm used within RadixSort
    private static void countingSort(Long[] arr, int bitsPerDigit, int digitIndex) {
        Long[] output = new Long[arr.length];
        int[] count = new int[1 << bitsPerDigit]; // Count array based on the base
        // Count occurrences of each digit
        for (int i = 0; i < arr.length; i++) {
            int a = extractDigit(arr[i], bitsPerDigit, digitIndex);
            count[a]++;
        }
        // Update count array to position elements correctly
        for (int j = 1; j < count.length; j++) {
            count[j] = count[j] + count[j - 1];
        }
        // Build the output array
        for (int j = arr.length - 1; j >= 0; j--) {
            int b = extractDigit(arr[j], bitsPerDigit, digitIndex);
            output[count[b] - 1] = arr[j];
            count[b] = count[b] - 1;
        }
        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
