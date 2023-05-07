package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Exercise7 {
    public static void main(String[] args) throws IOException {
        final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));

        words.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }
}
