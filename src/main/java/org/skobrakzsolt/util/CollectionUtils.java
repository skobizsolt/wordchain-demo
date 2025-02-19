package org.skobrakzsolt.util;

import java.util.List;

/**
 * Utility class for Collections.
 */
public class CollectionUtils {

    CollectionUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class!");
    }

    /**
     * Method to check if an array is null or empty.
     *
     * @param list source list
     * @return true/false
     */
    public static boolean isEmpty(final List<String> list) {
        return list == null || list.isEmpty();
    }
}
