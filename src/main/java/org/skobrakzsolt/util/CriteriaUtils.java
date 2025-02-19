package org.skobrakzsolt.util;

import java.util.List;

/**
 * Utility class for different word criteria.
 */
public class CriteriaUtils {

    CriteriaUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class!");
    }

    /**
     * Method to compare if the word is changed by only one character.
     *
     * @param currentWord   the reference word
     * @param inspectedWord the inspected word
     * @return true/false
     */
    public static boolean isWordChangedByOneCharacter(String currentWord, String inspectedWord) {
        var difference = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != inspectedWord.charAt(i)) {
                difference++;
                if (difference > 1) {
                    return false;
                }
            }
        }
        return difference == 1;
    }

    /**
     * Method to compare if only one word deleted or inserted.
     *
     * @param wordsOrderedBySize the 2 words, ordered by its length
     * @return true/false
     */
    public static boolean isOneCharacterInsertedOrDeleted(List<String> wordsOrderedBySize) {
        final var firstWord = wordsOrderedBySize.get(0);
        final var secondWord = wordsOrderedBySize.get(1);

        int i = 0;
        int j = 0;
        boolean isDifferenceFound = false;
        while (i < firstWord.length() && j < secondWord.length()) {
            if (firstWord.charAt(i) != secondWord.charAt(j)) {
                if (isDifferenceFound) {
                    return false;
                }
                isDifferenceFound = true;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }
}
