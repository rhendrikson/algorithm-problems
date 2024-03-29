package com.rhendrikson.algorithmproblems.arraysandstrings.permutationcheckstrategy;

import java.util.HashMap;

public class CharacterCountPermutationCheckStrategy implements PermutationCheckStrategy {

    public boolean isPermutation(String source, String permutation) {
        if (source == null || permutation == null) return false;
        
        if (source.isEmpty() || permutation.isEmpty()) return false;
        
        if (source.length() != permutation.length()) return false;
        
        HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>(source.length());
        for (Character character : source.toCharArray()) {
            int count = characterCounts.get(character) == null ? 0 : characterCounts.get(character);
            characterCounts.put(character, ++count);
        }
        
        for (Character character : permutation.toCharArray()) {
            int count = characterCounts.get(character) == null ? 0 : characterCounts.get(character);
            characterCounts.put(character, --count);
            if (count < 0) return false;
        }
        
        return true;
    }

}
