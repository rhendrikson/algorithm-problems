package com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy;

import java.util.Arrays;

public class SortUniqueCharacterStrategy implements UniqueCharacterStrategy {
    
    public boolean areCharactersUnique(String string) {
        char[] characters = string.toCharArray();
        Arrays.sort(characters);
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == characters[i - 1]) return false;
        }
        return true;
    }

}
