import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.sun.corba.se.impl.naming.cosnaming.NamingContextImpl.debug;

public class MergeSort<T> implements Sorter<T> {

    private Comparator<T> comparator;

    MergeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public T[] sort(T[] toSort) {
        return null;
    }

}

