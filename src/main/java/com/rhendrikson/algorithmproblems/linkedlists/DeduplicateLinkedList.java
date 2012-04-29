package com.rhendrikson.algorithmproblems.linkedlists;

import java.util.HashMap;

import com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy.DeduplicateLinkedListStrategy;

public class DeduplicateLinkedList {
    
    private DeduplicateLinkedListStrategy strategy;
    
    public void setStrategy(DeduplicateLinkedListStrategy strategy) {
        this.strategy = strategy;
    }
    
    public <E extends Comparable<E>> void deduplicate(SinglyLinkedListNode<E> head) {
        strategy.deduplicate(head);
    }
    
    public <E extends Comparable<E>> boolean hasDuplicate(SinglyLinkedListNode<E> head) {
        HashMap<E, Integer> elementCounts = new HashMap<E, Integer>();
        for (SinglyLinkedListNode<E> node : head) {
            int elementCount = elementCounts.get(node.data) == null ? 0 : elementCounts.get(node.data);
            elementCounts.put(node.data, ++elementCount);
            if (elementCount > 1) {
                return true;
            }
        }
        
        return false;
    }

}
