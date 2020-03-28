package sortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     * 时间复杂度: nlogn
     * 空间复杂度: n
     *
     * @param array 待排序数组
     * @param low   左边界
     * @param high  右边界
     */
    public static void mergeSort(int[] array, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) >> 1;
        mergeSort(array, low, mid);  // 左半部分归并排序
        mergeSort(array, mid + 1, high);  // 右半部分归并排序
        merge(array, low, mid, high);  // 合并左右归并结果
        System.out.println("...... " + Arrays.toString(array) + " ......");
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int l = low, m = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];
        while (l <= mid && m <= high) {
            if (array[l] <= array[m]) {
                temp[k++] = array[l++];
            } else {
                temp[k++] = array[m++];
            }
        }
        while (l <= mid) temp[k++] = array[l++];
        while (m <= high) temp[k++] = array[m++];
        for (int i : temp) {
            array[low++] = i;
        }
    }

}
