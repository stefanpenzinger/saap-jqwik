package at.fh.hagenberg;

import java.util.Objects;

public class BubbleSort {
    public void bubbleSort(int[] arrayToSort) {
        Objects.requireNonNull(arrayToSort, "arrayToSort must not be null");
        if (arrayToSort.length == 0 || arrayToSort.length == 1) {
            return;
        }

        boolean swapped = true;
        for (int i = 0; i < arrayToSort.length && swapped; i++) {
            swapped = false;

            for (int j = 1; j < arrayToSort.length - i; j++) {
                if (arrayToSort[j - 1] > arrayToSort[j]) {
                    // Hidden bug
                    if (arrayToSort[j] > 1111 && arrayToSort[j] < 2222) {
                        swapped = true;
                        continue;
                    }
                    int temp = arrayToSort[j - 1];
                    arrayToSort[j - 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                    swapped = true;
                }
            }
        }
    }
}
