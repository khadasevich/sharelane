package streamapidemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static List<String> newCollection = Arrays.asList("High", "Highload", "Load", "Stream", "High", "Idea", "Zet", "Wow");

    public void createStreamFromCollection() throws IOException {
        //Stream from collection
        List<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.stream();
        //Stream from values
        Stream.of("one", "two", "three");
        //Stream from array
        String[] array = {"one", "two", "three"};
        Arrays.stream(array);
        //Stream from file
        Stream<String> streamFromFile = Files.lines(Paths.get("src/test/resources/file_for_demo"));
        //Stream from chars
        IntStream stream = "123".chars();
        //Stream via builder
        Stream.builder().add("1").add("2").add("3").build();
    }

    public static long getQuantityOfElements() {
        // Варинт подсчета количества элементов без стрима
        int i = 0;
        for (String element : newCollection
        ) {
            if (element.equals("High")) {
                i += 1;
            }
        }
        //Вариант решения со стримом
        return newCollection.stream().filter("High"::equals).count();
    }

    public static String getFirstElement() {
        return newCollection.stream().findFirst().get();
    }

    public static String getLastElement() {
        return newCollection.stream().skip(newCollection.size() - 1).findFirst().get();
    }

    public static String skipFirstAndGetLastElement() {
        return newCollection.stream().skip(1).findFirst().get();
    }

    public static List<String> sortCollection() {
        return newCollection.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getQuantityOfElements());
        System.out.println(getFirstElement());
        System.out.println(getLastElement());
        System.out.println(skipFirstAndGetLastElement());
        System.out.println(sortCollection());
    }

}
