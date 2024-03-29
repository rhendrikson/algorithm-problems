package com.rhendrikson.algorithmproblems.arraysandstrings;

import java.util.Arrays;

public class ArrayHelper {
    
    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

}
