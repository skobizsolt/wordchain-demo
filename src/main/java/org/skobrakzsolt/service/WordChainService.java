package org.skobrakzsolt.service;

import org.skobrakzsolt.util.CriteriaUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * Service class to assemble valid word chains.
 */
public class WordChainService {

    public List<String> getChainedWords(List<String> words) {
        for (String word : words) {
            List<String> currentChainState = new ArrayList<>();
            Set<String> wordsUsed = new HashSet<>();

            final boolean isChainFinal = buildChain(word, words, currentChainState, wordsUsed);
            if (isChainFinal) {
                return currentChainState;
            }
        }
        return Collections.emptyList();
    }

    private static boolean buildChain(String currentWord,
                                      List<String> words,
                                      List<String> chain,
                                      Set<String> usedWords) {
        usedWords.add(currentWord);
        chain.add(currentWord);

        if (chain.size() == words.size()) {
            return true;
        }
        for (String word : words) {
            if (!usedWords.contains(word)
                    && isSimilarWord(word, currentWord)
                    && buildChain(word, words, chain, usedWords)) {
                    return true;
            }
        }
        usedWords.remove(currentWord);
        chain.remove(chain.size() - 1);
        return false;
    }

    private static boolean isSimilarWord(String inspectedWord, String currentWord) {
        int lengthDifference = Math.abs(currentWord.length() - inspectedWord.length());
        return switch (lengthDifference) {
            case 1 -> CriteriaUtils.isOneCharacterInsertedOrDeleted(
                    Stream.of(currentWord, inspectedWord)
                            .sorted(Comparator.comparing(String::length))
                            .toList());
            case 0 -> CriteriaUtils.isWordChangedByOneCharacter(currentWord, inspectedWord);
            default -> false;
        };
    }
}
