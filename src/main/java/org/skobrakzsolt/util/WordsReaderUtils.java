package org.skobrakzsolt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Utility class for reading words from different inputs.
 */
public final class WordsReaderUtils {

    private static final String FILE_PATH = "src/main/resources/words.txt";

    WordsReaderUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class!");
    }

    /**
     * Method to read words from console, using {@link Scanner}.
     * Only 1 line is read.
     *
     * @return {@link List} of strings.
     */
    public static List<String> readFromConsole(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Input: ");
        return getNaturallyOrderedWords(scanner.nextLine());
    }

    /**
     * Method to read strings from file, using {@link Scanner}.
     *
     * @return {@link List} of strings.
     */
    public static List<String> readFromFile() {
        try {
            List<String> words = getNaturallyOrderedWords(Files.readString(Path.of(FILE_PATH)));
            System.out.printf("Input: %s%n", String.join(" ", words));
            return words;
        } catch (IOException e) {
            System.out.printf("Error during reading file: %s%n", e.getMessage());
        }
        return Collections.emptyList();
    }

    /**
     * Method to get words in ordered by length, then by natural order.
     * This ensures that the word chain will also work with digits and numbers alike.
     *
     * @param data Source data that comes from the console or file.
     * @return the ordered List of data.
     */
    private static List<String> getNaturallyOrderedWords(final String data) {
        return Arrays.stream(data.split(" "))
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();
    }

}
