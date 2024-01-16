package at.fh.hagenberg;

import net.jqwik.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BubbleSortPropertyTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    @Property
    boolean arrayIsSorted(@ForAll int[] integerArray) {
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

    @Property
    boolean arrayIsSortedDomainSpecific(@ForAll("integersNotBetween1112And2221") Integer[] integerArray) {
        boolean isSorted = true;
        int arraySize = integerArray.length;
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = integerArray[i];
        }

        bubbleSort.bubbleSort(arr);

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

    @Provide
    public Arbitrary<Integer[]> integersNotBetween1112And2221() {
        return Arbitraries.integers()
                .between(0, 100)
                .array(Integer[].class)
                .ofMinSize(0)
                .ofMaxSize(30)
                .map(anArray -> {
                    Arrays.sort(anArray);
                    return Arrays.stream(anArray)
                            .filter(value -> value < 1112 || value > 2221)
                            .toArray(Integer[]::new);
                });
    }
}
