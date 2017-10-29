import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String fileName = "/home/shook/Downloads/braslet.txt";

        List<String> textWords = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((str) -> appendSplitted(str, textWords));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<String> myComp = Comparator.comparingInt(o -> o.charAt(0));

        String[] res = new MergeSort<>(myComp).sort((textWords.toArray(new String[0])));
        

        for (int i=0; i < 100; i++) {
            System.out.println(res[i]);
        }
    }

    private static void appendSplitted(String str, List<String> arr) {
        StringBuilder buffer = new StringBuilder();
        for (int i=0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                buffer.append(str.charAt(i));
            } else {
                if (buffer.length() > 0) arr.add(buffer.toString());
                buffer.setLength(0);
            }
        }

        if (buffer.length() > 0) arr.add(buffer.toString().toLowerCase());
    }
}
