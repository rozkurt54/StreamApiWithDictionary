package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise3 {
    private static final Function<String, String> first3CharsMapper = word -> word.length() >= 3 ? word.substring(0, 3) : word;

    private static final Collector<String, ?, Map<String, List<String>>> clusteredIndexCollector = Collectors.groupingBy(first3CharsMapper);

    private static final BiConsumer<String, List<String>> clusteredIndexPrinter = (index, list) -> {
        System.out.println(index + ": " + list);
    };

    // Group the dictionary words by their first three letters
    public static void main(String[] args) throws Exception {
        final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));

        var clusteredIndex = words.stream()
                .collect(clusteredIndexCollector);

        clusteredIndex.forEach(clusteredIndexPrinter);

    }

}
