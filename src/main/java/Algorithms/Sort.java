package Algorithms;

import java.util.Arrays;

public class Sort {

    public static void insertionSort(int[] arr) {
        int key, j, length = arr.length;

        for (int i = 1; i < length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {

        int temp, length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] arr) {
        int index_min, temp, length = arr.length;

        for (int i = 0; i < length; i++) {
            index_min = i;
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[index_min]) {
                    index_min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index_min];
            arr[index_min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 10};

//        insertionSort(arr);
//        bubbleSort(arr);
//        selectionSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

}
