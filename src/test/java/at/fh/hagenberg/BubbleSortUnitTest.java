package at.fh.hagenberg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BubbleSortUnitTest {
    @Test
    void testBubbleSort() {
        //given
        int[] arrayToSort = {5, 1, 4, 2, 8};

        //when
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arrayToSort);

        //then
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arrayToSort);
    }

    @Test
    void testBubbleSort_whenArrayContainsNegativeNumbers() {
        //given
        int[] arrayToSort = {5, 1, 4, 2, 8, -1, -2, -3, -4, -5};

        //when
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arrayToSort);

        //then
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1, 1, 2, 4, 5, 8}, arrayToSort);
    }

    @Test
    void testBubbleSort_whenArrayIsEmpty() {
        //given
        int[] arrayToSort = {};

        // when
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arrayToSort);

        //then
        assertArrayEquals(new int[]{}, arrayToSort);
    }

    @Test
    void testBubbleSort_whenArrayIsNull() {
        //given
        int[] arrayToSort = null;

        // when
        BubbleSort bubbleSort = new BubbleSort();
        assertThrows(NullPointerException.class, () -> bubbleSort.bubbleSort(arrayToSort));
    }
}
