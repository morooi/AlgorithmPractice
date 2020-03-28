package binarySearch;

public class Test {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 4, 6, 10, 11, 15, 20, 22, 33};
        System.out.println(SingleOne.search(array1, 11));

        int[] array2 = {1, 2, 4, 4, 4, 11, 15, 15, 20, 22, 28, 33};
        System.out.println(LeftOne.search(array2, 34));
        System.out.println(RightOne.search(array2, 34));
    }

}
