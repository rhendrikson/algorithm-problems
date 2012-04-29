package com.rhendrikson.algorithmproblems.arraysandstrings;

import com.rhendrikson.algorithmproblems.arraysandstrings.compressionstrategy.CompressionStrategy;
import com.rhendrikson.algorithmproblems.arraysandstrings.compressionstrategy.StringBuilderCompressionStrategy;

public class StringCompressor {
    
    private CompressionStrategy strategy;
    
    public StringCompressor() {
        this.strategy = new StringBuilderCompressionStrategy();
    }
    
    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public String compress(String source) {
        return strategy.compress(source);
    }
    
}
