package org.skobrakzsolt.util;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectionUtilsTest {

    @Test
    void isEmpty_null() {
        // given
        // when
        final boolean result = CollectionUtils.isEmpty(null);
        // then
        assertTrue(result);
    }

    @Test
    void isEmpty_empty() {
        // given
        // when
        final boolean result = CollectionUtils.isEmpty(Collections.emptyList());
        // then
        assertTrue(result);
    }

    @Test
    void isEmpty_false() {
        // given
        // when
        final boolean result = CollectionUtils.isEmpty(List.of("Test"));
        // then
        assertFalse(result);
    }
}