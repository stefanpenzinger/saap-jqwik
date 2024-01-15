package at.fh.hagenberg;

import net.jqwik.api.*;

public class BubbleSortPropertyTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    @Property
    boolean array_is_sorted(@ForAll int[] integerArray) {
        boolean isSorted = true;
        bubbleSort.bubbleSort(integerArray);

        if (integerArray.length == 0 || integerArray.length == 1) {
            return isSorted;
        }

        for (int i = 1; i < integerArray.length; i++) {
            if (integerArray[i - 1] > integerArray[i]) {
                isSorted = false;
                return isSorted;
            }
        }

        return isSorted;
    }
}
