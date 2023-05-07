package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Exercise1 {

      // Find the words starting with letters a to m
      public static void main(String[] args) throws IOException {
            final List<String> words = Files.readAllLines(Paths.get("src/main/resources/", "dictionary.txt"));
            System.out.println(words.size());
            words.stream().takeWhile(line -> line.matches("^[a-m].*$")).forEach(System.out::println);

      }
}
