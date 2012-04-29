package com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy;

import com.rhendrikson.algorithmproblems.arraysandstrings.UniqueCharactersString;

public class CharacterFlagUniqueCharacterStrategy implements UniqueCharacterStrategy {
    
    public boolean areCharactersUnique(String string) {
        boolean[] characterFlags = new boolean[UniqueCharactersString.ASCII_CHARACTER_COUNT];
        for (int i = 0; i < string.length(); i++) {
            int characterAscii = string.charAt(i);
            if (characterFlags[characterAscii]) return false;
            characterFlags[characterAscii] = true;
        }
        return true;
    }

}
