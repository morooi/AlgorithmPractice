package sortAlgorithm;

import java.util.Arrays;

import static sortAlgorithm.Main.swap;

public class BubbleSort {

    /**
     * 冒泡排序, 稳定
     * 时间复杂度: n ~ n^2
     * 空间复杂度: 1
     *
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        if (array.length <= 1) return;
        int high = array.length - 1;
        System.out.println(high);
        while (high > 0) {
            int k = high;
            high = 0;
            for (int i = 0; i < k; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    high = i;
                }
            }
            System.out.println("... " + Arrays.toString(array) + " ...");
        }
    }
}
