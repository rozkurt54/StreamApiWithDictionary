package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise2 {
      // Find the words starting with the letter n to the end of the dictionary
      public static void main(String[] args) throws IOException {
            final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));
            words.stream()
                        .dropWhile(line -> line.matches("[a-m].*$")).forEach(System.out::println);
      }
}
