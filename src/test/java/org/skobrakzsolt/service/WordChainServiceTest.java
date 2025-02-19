package org.skobrakzsolt.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skobrakzsolt.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordChainServiceTest {
    private WordChainService wordChainService;

    @BeforeEach
    void setUp() {
        wordChainService = new WordChainService();
    }

    @Test
    void test_getChainedWords() {
        // given
        final var source = List.of("coat", "hat", "hot", "dog", "cat", "hog", "cot", "oat");
        final var expected = List.of("coat", "cot", "cat", "oat", "hat", "hot", "hog", "dog");
        // when
        final List<String> result = wordChainService.getChainedWords(source);
        // then
        assertEquals(expected, result);
    }

    @Test
    void test_getChainedWords_notChainable() {
        // given
        final var source = List.of("alma", "körte", "barack");
        // when
        final List<String> result = wordChainService.getChainedWords(source);
        // then
        assertTrue(CollectionUtils.isEmpty(result));
    }
}