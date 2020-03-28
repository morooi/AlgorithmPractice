class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(nums, 20));

    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int colum = columns - 1;
        while (row < rows && colum >= 0) {
            if (target == matrix[row][colum]) {
                return true;
            } else if (target < matrix[row][colum]) {
                colum--;
            } else if (target > matrix[row][colum]) {
                row++;
            }
        }
        return false;
    }
}