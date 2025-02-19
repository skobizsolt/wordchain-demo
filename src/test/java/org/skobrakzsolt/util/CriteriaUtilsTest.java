package org.skobrakzsolt.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CriteriaUtilsTest {

    @Test
    void test_isWordChangedByOneCharacter() {
        // given
        // when
        final boolean result =
                CriteriaUtils.isWordChangedByOneCharacter("ABC", "ABD");
        // then
        assertTrue(result);
    }

    @Test
    void test_isWordChangedByOneCharacter_moreThanOne() {
        // given
        // when
        final boolean result =
                CriteriaUtils.isWordChangedByOneCharacter("ABCD", "DCAB");
        // then
        assertFalse(result);
    }

    @Test
    void test_isOneCharacterInsertedOrDeleted() {
        // given
        // when
        final boolean result =
                CriteriaUtils.isOneCharacterInsertedOrDeleted(List.of("oat", "coat"));
        // then
        assertTrue(result);
    }
}