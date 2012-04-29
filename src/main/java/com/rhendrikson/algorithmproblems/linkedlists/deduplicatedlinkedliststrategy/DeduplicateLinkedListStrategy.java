package com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy;

import com.rhendrikson.algorithmproblems.linkedlists.SinglyLinkedListNode;

public interface DeduplicateLinkedListStrategy {
    <E extends Comparable<E>> void deduplicate(SinglyLinkedListNode<E> head);
}
