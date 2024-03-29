package com.rhendrikson.algorithmproblems.linkedlists;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedListNode<E extends Comparable<E>> implements Iterable<SinglyLinkedListNode<E>> {
    
    public E data;
    public SinglyLinkedListNode<E> next;
    
    public SinglyLinkedListNode() {}
    
    public SinglyLinkedListNode(E data, SinglyLinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }
    
    public SinglyLinkedListNode(E... data) {
        SinglyLinkedListNode<E> current = this;
        for (int i = 0; i < data.length; i++) {
            current.data = data[i];
            if (i == data.length - 1) break;
            current.next = new SinglyLinkedListNode<E>();
            current = current.next;
        }
    }
    
    public void append(E data) {
        SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(data, null);
        SinglyLinkedListNode<E> tail = this;
        
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }
    
    public int length() {
        int length = 0;
        SinglyLinkedListNode<E> current = this;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    private SinglyLinkedListNode<E> self() {
        return this;
    }

    public Iterator<SinglyLinkedListNode<E>> iterator() {
        return new Iterator<SinglyLinkedListNode<E>>() {
            
            private SinglyLinkedListNode<E> current = self();

            public boolean hasNext() {
                return (current != null);
            }

            public SinglyLinkedListNode<E> next() {
                SinglyLinkedListNode<E> previous = current;
                current = current.next;
                return previous;
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
    
    @Override
    public boolean equals(Object head) {
        if (head == null) return false;
        if (head == this) return true;
        if (head.getClass() != this.getClass()) return false;
        
        SinglyLinkedListNode<E> current = this;
        @SuppressWarnings("unchecked")
		SinglyLinkedListNode<E> compareRunner = (SinglyLinkedListNode<E>) head;
        
        while (current != null) {
            if (compareRunner == null ||
                current.data.compareTo(compareRunner.data) != 0) {
                return false;
            }
            current = current.next;
            compareRunner = compareRunner.next;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.next);
        return hash;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SinglyLinkedListNode<E> node : this) {
            stringBuilder.append(node.data);
            if (node.next != null) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

}
