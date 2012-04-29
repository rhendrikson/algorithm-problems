package com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy;

public class BitFlagUniqueCharacterStrategy implements UniqueCharacterStrategy {

    public boolean areCharactersUnique(String string) {
        char bitFlag = Character.MIN_VALUE;
        for (int i = 0; i < string.length(); i++) {
            int value = string.charAt(i);
            if ((bitFlag & (1 << value)) > Character.MIN_VALUE) {
                return false;
            }
            bitFlag |= (1 << value);
        }
        return true;
    }

}
