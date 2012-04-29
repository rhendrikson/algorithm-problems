package com.rhendrikson.algorithmproblems.arraysandstrings.permutationcheckstrategy;

import com.rhendrikson.algorithmproblems.arraysandstrings.StringHelper;

public class SortPermutationCheckStrategy implements PermutationCheckStrategy {

    public boolean isPermutation(String source, String permutation) {
        if (source == null || permutation == null) return false;
        
        if (source.isEmpty() || permutation.isEmpty()) return false;
        
        if (source.length() != permutation.length()) return false;
        
        if (source.length() == 1) {
            return source.equals(permutation);
        }
        
        return StringHelper.sort(source).equals(StringHelper.sort(permutation));
    }

}
