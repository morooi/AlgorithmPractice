package binarySearch;

public class SingleOne {

    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int num = array[mid];
            if (num == target) {
                return mid;  // num == target
            } else if (num < target) {
                left = mid + 1;  // num < target
            } else {
                right = mid - 1;  // num > target
            }
        }
        return -1;
    }
}
