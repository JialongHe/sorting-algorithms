package murraco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import murraco.BubbleSort;
import murraco.Heapsort;
import murraco.InsertionSort;
import murraco.MergeSort;
import murraco.Quicksort;
import murraco.SelectionSort;

public class SortingAlgorithmsTest {
  @Test
  public void shouldReturnEmptySetBubbleSort() {
    final Integer[] data = {};
    BubbleSort.bubbleSort(data);
    assertEquals("[]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnSingleElementHeapSort() {
    final Integer[] data = {99};
    Heapsort.heapSort(data);
    assertEquals("[99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingOrderInsertionSort() {
    final Integer[] data = {0, 1, 3, 4, 5, 7, 11, 12, 15, 99};
    InsertionSort.insertionSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingOrderMergeSort() {
    final Integer[] data = {99, 15, 12, 11, 7, 5, 4, 3, 1, 0};
    MergeSort.mergeSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingOrderWithDuplicationQuicksort() {
    final Integer[] data = {99, 15, 15, 15, 7, 7, 7, 7, 1, 0};
    Quicksort.quickSort(data);
    assertEquals("[0, 1, 7, 7, 7, 7, 15, 15, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingOrderQuicksort() {
    final Integer[] data = {1, 3, 4, 5, 0, 7, 11, 12, 15, 99};
    Quicksort.quickSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingOrderWithNegativeNumbersQuicksort() {
    final Integer[] data = {-1, -3, 4, 5, 0, -7, 11, -12, 15, 99};
    Quicksort.quickSort(data);
    assertEquals("[-12, -7, -3, -1, 0, 4, 5, 11, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void shouldReturnAscendingStringsBubbleSort() {
    final String[] data = {"quality", "mentimeter", "", "assignment2", "cry"};
    BubbleSort.bubbleSort(data);
    assertEquals("[, assignment2, cry, mentimeter, quality]", Arrays.toString(data));
  }
  @Test
  public void shouldReturnAscendingStringsWithCasesBubbleSort() {
    final String[] data = {"Quality", "quality", "Mentimeter", "", "assignment", "Assignment"};
    BubbleSort.bubbleSort(data);
    assertEquals("[, Assignment, Mentimeter, Quality, assignment, quality]", Arrays.toString(data));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowNullPointerExceptionBubbleSort() {
    final Integer[] data = {null, 1, 0, null, 3, 99};
    BubbleSort.bubbleSort(data);
  }

  @Test(expected = NumberFormatException.class)
  public void shouldThrowNumberFormatExceptionBubbleSort() {
    final Integer[] data = {Integer.parseInt("2147483648"), 2147483647, -2147483648, 1, 0};
    BubbleSort.bubbleSort(data);
    assertEquals("[-2147483648, 0, 1, 2147483647, 2147483648]", Arrays.toString(data));
  }

  boolean isSorted(Integer[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1])
        return false;
    }
    return true;
  }
  public static Integer[] generateRandomIntArray(int size) {
    Integer[] randomArray = new Integer[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      randomArray[i] = random.nextInt();
    }
    return randomArray;
  }
  @Test(timeout = 50)
  public void shouldReturnSortedArray() {
    final Integer[] data = generateRandomIntArray(10000);
    // Would timeout for InsertionSort
    // InsertionSort.insertionSort(data);
    Quicksort.quickSort(data);
    assertTrue(isSorted(data));
  }

  @Test
  public void testBubbleSort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    BubbleSort.bubbleSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void testInsertionSort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    InsertionSort.insertionSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void testSelectionSort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    SelectionSort.selectionSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void testMergeSort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    MergeSort.mergeSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void testHeapsort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    Heapsort.heapSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }

  @Test
  public void testQuicksort() {
    final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
    Quicksort.quickSort(data);
    assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
  }
}
