package com.utils;

public class StringUtils {

    public static boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }

    private StringUtils() { }
}
