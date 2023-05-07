package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise6 {

    public static void main(String[] args) throws IOException {
        final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));

        System.out.println(words.stream().filter(word -> word.matches("^a.*z$")).findFirst().orElse("Not found"));

        words.stream().filter(word -> word.matches("^a.*z$")).forEach(System.out::println);

    }

}
