package binarySearch;

public class RightOne {

    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int num = array[mid];
            if (num == target) {
                left = mid + 1;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || array[right] != target) return -1;
        return right;
    }

}
