package binarySearch;

public class LeftOne {

    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int num = array[mid];
            if (num == target) {
                right = mid - 1;  // num == target
            } else if (num > target) {
                right = mid - 1;  // num > target
            } else {
                left = mid + 1;  // num < target
            }
        }
        if (left >= array.length || array[left] != target) return -1;
        return left;
    }

}
