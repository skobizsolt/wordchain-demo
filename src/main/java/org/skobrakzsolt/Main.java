package org.skobrakzsolt;

import org.skobrakzsolt.service.WordChainService;
import org.skobrakzsolt.util.CollectionUtils;
import org.skobrakzsolt.util.WordsReaderUtils;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        final var words = WordsReaderUtils.readFromConsole();
        final List<String> chainedWords = new WordChainService().getChainedWords(words);
        if (CollectionUtils.isEmpty(chainedWords)) {
            printErrorMessage();
            return;
        }

        System.out.printf("Output: %s%n", String.join(" ", chainedWords));
    }

    private static void printErrorMessage() {
        System.out.println("Hiba: a megadott szavakból nem lehetséges szóláncot építeni!");
    }
}