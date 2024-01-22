package com.hepsiburada.utils;

import java.util.HashMap;
import java.util.Map;

// That class aims to store data to use between test scenarios
public class LocalStorageUtils {

    public static String CURRENT_PRODUCT_MERCHANT_NAME_KEY = "MERCHANT_NAME";
    public static String CURRENT_PRODUCT_NUMBER_OF_REVIEWS_KEY = "NUMBER_OF_REVIEWS";

    private static final Map<String, String> localStorage = new HashMap<>();

    public static void setItem(String key, String value) {
        localStorage.put(key, value);
    }

    public static String getItem(String key) {
        return localStorage.get(key);
    }

    public static void removeItem(String key) {
        localStorage.remove(key);
    }

    public static void clear() {
        localStorage.clear();
    }

    public static int size() {
        return localStorage.size();
    }

    public static boolean containsKey(String key) {
        return localStorage.containsKey(key);
    }
}

