package com.rhendrikson.algorithmproblems.arraysandstrings;

import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.CharacterFlagUniqueCharacterStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.UniqueCharacterStrategy;

public class UniqueCharactersString {
    
    public static final int ASCII_CHARACTER_COUNT = 256;
    private UniqueCharacterStrategy strategy = new CharacterFlagUniqueCharacterStrategy();
        
    public boolean areAllCharactersUnique(String string) {
        if (string.isEmpty()) return false;
        
        if (string.length() == 1) return true;
        
        if (string.length() > ASCII_CHARACTER_COUNT) return false;

        return this.strategy.areCharactersUnique(string);
    }
    
    public void setStrategy(UniqueCharacterStrategy strategy) {
        this.strategy = strategy;
    }
    
}
