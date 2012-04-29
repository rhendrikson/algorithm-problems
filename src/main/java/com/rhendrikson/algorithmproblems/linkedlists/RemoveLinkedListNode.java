package com.rhendrikson.algorithmproblems.linkedlists;

public class RemoveLinkedListNode {
    
    public static <E extends Comparable<E>> void remove(SinglyLinkedListNode<E> target) {
        if (target == null || target.next == null) {
            throw new UnsupportedOperationException();
        }        
        
        target.data = (E) target.next.data;
        target.next = target.next.next;
    }

}
