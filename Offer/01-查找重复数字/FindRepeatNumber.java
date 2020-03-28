import java.util.HashSet;

public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            } else {
                hashSet.add(num);
            }
        }
        return -1;
    }
}