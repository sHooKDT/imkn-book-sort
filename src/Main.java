import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String fileName = "/Users/shook/Downloads/braslet.txt";

        List<String> textWords = new ArrayList<>();

        System.out.println("Starting measuring time:");

        long start = System.nanoTime();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((str) -> appendSplitted(str, textWords));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Reading & splitting done in %d milliseconds \n", (System.nanoTime() - start) / 1000 / 1000);

        Comparator<String> myComp = Comparator.comparingInt(o -> o.charAt(0));

        String[] sourceArr = textWords.toArray(new String[0]);

        for (Sorter sorter : new Sorter[] {
                new BubbleSort<>(myComp),
                new MergeSort<>(myComp),
                new ShakerSort<>(myComp),
                new QuickSort<>(myComp)
        }) {
            start = System.nanoTime();
            ((Sorter<String>) sorter).sort(sourceArr);
            System.out.printf("%s done in %d milliseconds \n", sorter.getClass().toString(), (System.nanoTime() - start) / 1000 / 1000);
        }
    }

    private static void appendSplitted(String str, List<String> arr) {
        StringBuilder buffer = new StringBuilder();
        for (int i=0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                buffer.append(str.charAt(i));
            } else {
                if (buffer.length() > 0) arr.add(buffer.toString().toLowerCase());
                buffer.setLength(0);
            }
        }

        if (buffer.length() > 0) arr.add(buffer.toString().toLowerCase());
    }
}
