package com.rhendrikson.algorithmproblems.arraysandstrings;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.rhendrikson.algorithmproblems.arraysandstrings.compressionstrategy.CharacterCopyCompressionStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.compressionstrategy.CompressionStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.compressionstrategy.StringBuilderCompressionStrategy;

@RunWith(Parameterized.class)
public class StringCompressorTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new StringBuilderCompressionStrategy() },
            { new CharacterCopyCompressionStrategy() }
        });
    }
    
    private StringCompressor stringCompressor;
    
    public StringCompressorTest(CompressionStrategy strategy) {
        stringCompressor = new StringCompressor();
        stringCompressor.setStrategy(strategy);
    }
    
    @Test
    public void testCompress() {
        assertEquals("a2b1c5a3", stringCompressor.compress("aabcccccaaa"));
    }
    
    @Test
    public void testCompressWithLongString() {
        assertEquals("a2b1c10a3", stringCompressor.compress("aabccccccccccaaa"));
    }

    @Test
    public void testCompressWithNonCompressableString() {
        String source = "abcdef";
        assertEquals(source, stringCompressor.compress(source));
    }
    
}
