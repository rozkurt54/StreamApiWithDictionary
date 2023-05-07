package org.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class Exercise5 {
    private static final BiConsumer<Integer, List<String>> printEntry = (key, value) -> System.out.format("%c : %d\n", key, value.size());


    public static void main(String[] args) throws IOException {
        final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));
        var d = words.stream()
                .flatMap(word -> word.chars().boxed().map(c-> pair(c, word)))
                .collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));

       d.keySet().forEach(item -> {
           d.get(item).forEach(item1 -> System.out.format("%c : %s\n", item, item1));
       });


    }

    private static <T, U> AbstractMap.SimpleEntry<T, U> pair(T t, U u) {
        return new AbstractMap.SimpleEntry<>(t, u);
    }
}
