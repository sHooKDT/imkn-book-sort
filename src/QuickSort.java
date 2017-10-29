import java.util.Comparator;

public class QuickSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    QuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public T[] sort(T[] toSort) {
        T[] result = toSort.clone();
        qsort(result, 0, result.length - 1);
        return result;
    }

    private void qsort(T[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];

            do {
                while (comparator.compare(arr[i], x) < 0) i++;
                while (comparator.compare(x, arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    }
}
