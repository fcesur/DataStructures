package Algorithms;

public class Search {

    private static int binarySearch(int[] arr, int key) {

        int mid, low, high, length = arr.length;

        low = 0;
        high = length - 1;

        while (low <= high) {
            mid = low + high / 2;

            if (arr[mid] == key)
                return mid;

            if (key > mid)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 10};

        System.out.println(binarySearch(arr, 5));
    }

}
