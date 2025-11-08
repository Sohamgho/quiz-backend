package com.wbjee.oceanapp.util;

public class MapperUtils {
    public static String safeUpper(String s) {
        return s == null ? null : s.trim().toUpperCase();
    }
}
