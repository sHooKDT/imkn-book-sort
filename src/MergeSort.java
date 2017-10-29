import java.util.Comparator;

public class MergeSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    MergeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private T[] values;

    private Object[] helper;

    @Override
    public T[] sort(T[] values) {
        this.values = values.clone();
        if (String.class.isInstance(values[0]))
        {
            this.helper = new String[this.values.length];
        } else {
            this.helper = (T[]) new Object[this.values.length];
        }
        mergesort(0, this.values.length - 1);
        return this.values;
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        System.arraycopy(values, low, helper, low, high + 1 - low);

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (comparator.compare((T) helper[i], (T) helper[j]) <= 0) {
                values[k] = (T) helper[i];
                i++;
            } else {
                values[k] = (T) helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            values[k] = (T) helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}

