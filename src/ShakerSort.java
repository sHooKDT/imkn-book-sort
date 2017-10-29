import java.util.Comparator;

public class ShakerSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    ShakerSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public T[] sort(T[] toSort) {
        T[] result = toSort.clone();
        shakerSort(result);
        return result;
    }

    /**
     * Shaker sort (bidirectional bubble sort)
     * Orders in descending order
     * @param array array to be sorted
     */
    private void shakerSort(T[] array) {
        for (int i = 0; i < array.length/2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j+1]) < 0) {
                    T tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    swapped = true;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (comparator.compare(array[j], array[j-1]) > 0) {
                    T tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}
