package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.function.Predicate;

public class Exercise4 {

    private static final Predicate<String> isPalindrome = word -> word.contains(new StringBuilder(word).reverse());

    public static void main(String[] args) throws IOException {

        final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));

        words.stream().filter(isPalindrome).forEach(System.err::println);

    }
}
