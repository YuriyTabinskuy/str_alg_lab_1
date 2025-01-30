import java.util.Arrays;

public class BasicAlgSort<T extends Comparable<? super T>> {
    private int left;
    private int right;
    private T[] array;

    public BasicAlgSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public BasicAlgSort(int left, int right, T[] array) {
        this.left = left;
        this.right = right;
        this.array = Arrays.copyOfRange(array, left, right);
    }

    public T[] getArray() {
        return array;
    }

    public void bubbleSortAsc() {
        boolean flagForIteration = true;
        while (flagForIteration) {
            flagForIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    swap(i, i - 1);
                    flagForIteration = true;
                }
            }
        }
    }

    private void swap(int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    public void selectionSortAsc() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            T min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(i, minIndex);
            }
        }
    }

    public void insertionSortWithLinearSearchAsc() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public void insertionSortWithBinarySearchAsc() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int leftIndex = 0;
            int rightIndex = i - 1;

            while (leftIndex <= rightIndex) {
                int mid = (leftIndex + rightIndex) / 2;
                if (key.compareTo(array[mid]) < 0) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            }

            for (int j = i; j > leftIndex; j--) {
                array[j] = array[j - 1];
            }
            array[leftIndex] = key;
        }
    }
}