package org.skobrakzsolt;

import org.skobrakzsolt.service.WordChainService;
import org.skobrakzsolt.util.CollectionUtils;
import org.skobrakzsolt.util.WordsReaderUtils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        final List<String> words = getWordsFromOption();

        final List<String> chainedWords = new WordChainService().getChainedWords(words);
        if (CollectionUtils.isEmpty(chainedWords)) {
            printErrorMessage();
            return;
        }

        System.out.printf("Output: %s%n", String.join(" ", chainedWords));
    }

    private static List<String> getWordsFromOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Choose the preferred method:
                    1. From console
                    2. From file
                Your option:
                """);

        return switch (scanner.nextInt()) {
            case 1 -> WordsReaderUtils.readFromConsole(scanner);
            case 2 -> WordsReaderUtils.readFromFile();
            default -> Collections.emptyList();
        };
    }

    private static void printErrorMessage() {
        System.out.println("Hiba: a megadott szavakból nem lehetséges szóláncot építeni!");
    }
}