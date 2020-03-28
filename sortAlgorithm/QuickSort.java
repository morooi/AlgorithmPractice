package sortAlgorithm;

import java.util.Arrays;

import static sortAlgorithm.Main.swap;

public class QuickSort {

    /**
     * 快速排序, 不稳定
     * 时间复杂度: nlogn ~ n^2
     * 空间复杂度: logn
     *
     * @param array 待排序数组
     * @param low   起点
     * @param high  终点
     */
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high) return;
        int l = low, r = high;
        while (l < r) {
            while (l < r && array[r] >= array[low]) r--;  // 一定要先减，然后再加
            while (l < r && array[l] <= array[low]) l++;
            if (l < r) {
                swap(array, l, r);
            }
        }
        swap(array, l, low);
        System.out.println("..... " + Arrays.toString(array) + " .....");
        quickSort(array, low, l - 1);
        quickSort(array, l + 1, high);
    }
}
