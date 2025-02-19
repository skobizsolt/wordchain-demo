package org.skobrakzsolt.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WordsReaderUtilsTest {

    @Test
    void readFromFile() {
        // given
        // when
        List<String> words = WordsReaderUtils.readFromFile();
        // then
        assertFalse(CollectionUtils.isEmpty(words));
        assertNotNull(words);
    }
}