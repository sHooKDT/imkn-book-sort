import java.util.Comparator;

public class BubbleSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    BubbleSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public T[] sort(T[] toSort) {
        T[] result = toSort.clone();
        int n = toSort.length;
        T temp = null;

        for(int i=0; i < n; i++)
            for (int j = 1; j < (n - i); j++)
                if (comparator.compare(result[j - 1], result[j]) > 0) {
                    //swap elements
                    temp = result[j - 1];
                    result[j - 1] = result[j];
                    result[j] = temp;
                }

        return result;
    }
}
