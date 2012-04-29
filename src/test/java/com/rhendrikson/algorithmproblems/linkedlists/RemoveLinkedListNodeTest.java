package com.rhendrikson.algorithmproblems.linkedlists;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveLinkedListNodeTest {

    @Test
    public void testRemove() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<Integer>(1, 2, 3, 4, 5);
        SinglyLinkedListNode<Integer> target = null;
        for (SinglyLinkedListNode<Integer> node : linkedList) {
            if (node.data.compareTo(3) == 0) {
                target = node;
                break;
            }
        }
        RemoveLinkedListNode.remove(target);
        
        int[] actual = new int[linkedList.length()];
        int i = 0;
        for (SinglyLinkedListNode<Integer> node : linkedList) {
            actual[i++] = node.data;
        }
        int[] expected = {1, 2, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveNullNode() {
    	SinglyLinkedListNode<Integer> nullNode = null;
        RemoveLinkedListNode.remove(nullNode);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveLastNode() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<Integer>(1, 2, 3, 4, 5);
        SinglyLinkedListNode<Integer> target = null;
        for (SinglyLinkedListNode<Integer> node : linkedList) {
            if (node.data.compareTo(5) == 0) {
                target = node;
                break;
            }
        }
        RemoveLinkedListNode.remove(target);
    }

}