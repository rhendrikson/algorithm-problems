package com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy;

import com.rhendrikson.algorithmproblems.linkedlists.SinglyLinkedListNode;

public class DeduplicateLinkedListWithRunnerStrategy implements DeduplicateLinkedListStrategy {

    public <E extends Comparable<E>> void deduplicate(SinglyLinkedListNode<E> head) {
        if (head == null) return;
        
        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> runner;        
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                if (runner.next.data.compareTo(current.data) == 0) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}
