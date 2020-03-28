package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

public class Main {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    @Test
    public void test() {
//        int[] array = new int[]{2, 12, 4, 4, 3, 7, 5, 10, 9, 1, 6, 8, 2};
        int[] array = new int[]{2, 12, 4, 4, 3, 7, 5, 10, 9, 1, 6, 8, 2, 45, 46, 47, 48, 50};
        System.out.println("排序前: " + Arrays.toString(array));
//        QuickSort.quickSort(array, 0, array.length - 1);  // 快速排序
//        BubbleSort.bubbleSort(array);  // 冒泡排序
//        StraightInsertionSort.straightInsertionSort(array);  // 直接插入排序
        HeapSort.heapSort(array);  // 堆排序
//        MergeSort.mergeSort(array,0,array.length - 1);  // 归并排序
        System.out.println("排序后: " + Arrays.toString(array));
    }

}
