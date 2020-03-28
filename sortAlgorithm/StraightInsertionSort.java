package sortAlgorithm;

import java.util.Arrays;

import static sortAlgorithm.Main.swap;

public class StraightInsertionSort {
    /**
     * 直接插入排序, 稳定
     * 时间复杂度: n ~ n^2
     * 空间复杂度: 1
     *
     * @param array 待排序数组
     */
    public static void straightInsertionSort(int[] array) {
        if (array.length <= 1) return;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
            System.out.println("... " + Arrays.toString(array) + " ...");
        }
    }

}
