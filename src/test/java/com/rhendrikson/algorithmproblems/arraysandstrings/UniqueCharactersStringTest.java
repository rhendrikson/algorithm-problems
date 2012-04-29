package com.rhendrikson.algorithmproblems.arraysandstrings;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.BitFlagUniqueCharacterStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.CharacterFlagUniqueCharacterStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.SortUniqueCharacterStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.uniquecharacterstrategy.UniqueCharacterStrategy;

@RunWith(Parameterized.class)
public class UniqueCharactersStringTest {

    @Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new CharacterFlagUniqueCharacterStrategy() },
            { new SortUniqueCharacterStrategy() },
            { new BitFlagUniqueCharacterStrategy() }
        });
    }
    
    private UniqueCharactersString uniqueCharactersString;
    
    public UniqueCharactersStringTest(UniqueCharacterStrategy strategy) {
        uniqueCharactersString = new UniqueCharactersString();
        uniqueCharactersString.setStrategy(strategy);
    }

    @Test
    public void testEmptyString() {
        String string = "";
        assertFalse(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testSingleCharacterString() {
        String string = "a";
        assertTrue(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testUniqueCharacterString() {
        String string = "qkibycghre";
        assertTrue(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testNonUniqueCharacterString() {
        String string = "qkibycighre";
        assertFalse(uniqueCharactersString.areAllCharactersUnique(string));
    }

}