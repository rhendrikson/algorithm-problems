package com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy;

import java.util.HashMap;

import com.rhendrikson.algorithmproblems.linkedlists.SinglyLinkedListNode;

public class DeduplicateLinkedListWithHashStrategy implements DeduplicateLinkedListStrategy {

    public <E extends Comparable<E>> void deduplicate(SinglyLinkedListNode<E> head) {
        HashMap<E, Integer> nodeCounts = new HashMap<E, Integer>();
        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> previous = current;
        while (current != null) {
            if (nodeCounts.get(current.data) != null &&
                nodeCounts.get(current.data).compareTo(1) == 0) {
                previous.next = current.next;
            } else {
                nodeCounts.put(current.data, 1);
                previous = current;
            }
            current = current.next;
        }
    }
    
}
