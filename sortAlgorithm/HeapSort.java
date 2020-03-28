package sortAlgorithm;

import java.util.Arrays;

import static sortAlgorithm.Main.swap;

public class HeapSort {

    /**
     * 堆排序, 不稳定
     * @param array 待排序数组
     */
    public static void heapSort(int[] array) {
        int heapSize = array.length;
        buildMaxHeap(array, heapSize);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, 0, i);
            System.out.println("... " + Arrays.toString(array) + " ...");
        }
    }

    private static void buildMaxHeap(int[] array, int heapSize) {
        for (int i = heapSize >> 1; i >= 0; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    private static void maxHeapify(int[] array, int i, int heapSize) {
        int l = (i << 1) + 1, r = (i << 1) + 2, largest = i;
        if (l < heapSize && array[l] > array[largest]) largest = l;
        if (r < heapSize && array[r] > array[largest]) largest = r;
        if (largest != i) {
            swap(array, i, largest);
            maxHeapify(array, largest, heapSize);
        }
    }
}