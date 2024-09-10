import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SorterTestIdan {

    @Test
    void quickSortArrayisSorted() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void quickSortArrayisReversed() {
        Integer[] array = new Integer[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void quickSortBubblesortCase() {
        Integer[] array = new Integer[]{9, 13, 7, 89, 5, 22, 311, 42, 177};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void quickSortArrayisempty() {
        Integer[] array = new Integer[]{};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void quickSortSameElements() {
        Integer[] array = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void quickSortSameElementsBubblesort() {
        Integer[] array = new Integer[]{1, 1, 0, 1, 1, 1, 1, 1};
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }



    final static long FIXED_RANDOMNESS_SEED = 12345L;
    Random randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new Random(FIXED_RANDOMNESS_SEED);
    }

    @Test
    void testQuicksortOnSmallArrayWithNarrowRangeOfValues() {
        Long[] array = randomArray(30, 100, 120);
        Sorter.quickSort(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    private Long[] randomArray(int length, long lowerBound, long upperBound) {
        if (length < 0) {
            throw new IllegalArgumentException("An array length can't be negative");
        }
        return randomGenerator.longs(length, lowerBound, upperBound).boxed().toArray(Long[]::new);
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testMergeSortOnMediumArrayWithWideRangeOfValues() {
        Long[] array = randomArray(1024, 0, 1_000_000);
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Mergesort did not sort the array");
    }

    @Test
    void mergeSortNoRecursion9elementsSorted() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void mergeSortNoRecursionSameElements() {
        Integer[] array = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void mergeSortNoRecursionArrayisnull() {
        Integer[] array = new Integer[]{};
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void mergeSortNoRecursionReversed() {
        Integer[] array = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void mergeSortNoRecursionNegative() {
        Integer[] array = new Integer[]{-1, 9, -8, 7, 6, -5, -4, 3, -2, 1};
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Quicksort did not sort the array");
    }

    @Test
    void mergeSortNoRecursionNegativeRandom() {
        Long[] array = randomArray(10000013, 0, 1_000_000_000);
        Sorter.mergeSortNoRecursion(array);
        assertTrue(isSorted(array), "Mergesort did not sort the array");
    }

    @Test
    void testQuickSort() {
        Integer[] array = {3, 6, 8, 10, 1, 2, 1, 4};
        Sorter.quickSort(array);
        System.out.println("QuickSort Result: " + Arrays.toString(array));
    }

    @Test
    void testMergeSortNoRecursion() {
        Integer[] array = {3, 6, 8, 10, 1, 2, 1, 4};
        Sorter.mergeSortNoRecursion(array);
        System.out.println("MergeSortNoRecursion Result: " + Arrays.toString(array));
    }

    @Test
    void testRadixSort() {
        Long[] array1 = {170L, 45L, 75L, 90L, 802L, 24L, 2L, 66L};
        System.out.println("Original Array 1: " + Arrays.toString(array1));
        Sorter.radixSort(array1, 8);
        System.out.println("RadixSort Result 1: " + Arrays.toString(array1));

        Long[] array2 = {9876543210L, 123456789L, 987654321L, 876543210L};
        System.out.println("Original Array 2: " + Arrays.toString(array2));
        Sorter.radixSort(array2, 16);
        System.out.println("RadixSort Result 2: " + Arrays.toString(array2));
    }

    @Test
    void testEmptyRadix() {
        Long[] array = {};
        Sorter.radixSort(array,4);
        assertTrue(isSorted(array));
    }
    @Test
    void radixSort() {
        Long[] singleElementArray = {100L};
        Sorter.radixSort(singleElementArray, 2); // Radix sort with radix 2
        assertTrue(isSorted(singleElementArray), "Radix sort did not sort the single-element array:\n" + Arrays.toString(singleElementArray));
    }
    @Test
    void radixSortedElements() {
        Long[] sortedArray = {10L, 20L, 30L, 40L, 50L};
        Sorter.radixSort(sortedArray, 2); // Radix sort with radix 2
        assertTrue(isSorted(sortedArray), "Radix sort did not handle the already sorted array:\n" + Arrays.toString(sortedArray));

    }
    @Test
    void radixElements() {
        Long[] array1 = {3L, 1L, 4L, 1L, 5L, 9L, 2L, 6L, 5L, 3L, 5L};
        Long[] array2 = {};
        Long[] array3 = {1L};
        Long[] array4 = {9L, 7L, 5L, 3L, 1L};
        Long[] array5 = {1L, 2L, 3L, 4L, 5L};

        Sorter.radixSort(array1, 4);
        Sorter.radixSort(array2, 4);
        Sorter.radixSort(array3, 4);
        Sorter.radixSort(array4, 4);
        Sorter.radixSort(array5, 4);

        assert isSorted(array1) : "RadixSort failed on array1";
        assert isSorted(array2) : "RadixSort failed on array2";
        assert isSorted(array3) : "RadixSort failed on array3";
        assert isSorted(array4) : "RadixSort failed on array4";
        assert isSorted(array5) : "RadixSort failed on array5";

    }

}
