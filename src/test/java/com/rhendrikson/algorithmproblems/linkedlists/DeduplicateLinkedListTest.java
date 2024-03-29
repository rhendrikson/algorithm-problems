package com.rhendrikson.algorithmproblems.linkedlists;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy.DeduplicateLinkedListStrategy;
import com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy.DeduplicateLinkedListWithHashStrategy;
import com.rhendrikson.algorithmproblems.linkedlists.deduplicatedlinkedliststrategy.DeduplicateLinkedListWithRunnerStrategy;

@RunWith(Parameterized.class)
public class DeduplicateLinkedListTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new DeduplicateLinkedListWithHashStrategy() },
            { new DeduplicateLinkedListWithRunnerStrategy() }
        });
    }
    
    private DeduplicateLinkedList deduplicateLinkedList;
    
    public DeduplicateLinkedListTest(DeduplicateLinkedListStrategy strategy) {
        deduplicateLinkedList = new DeduplicateLinkedList();
        deduplicateLinkedList.setStrategy(strategy);
    }

    @Test
    public void testDeduplicate() {
        SinglyLinkedListNode<Character> linkedList = new SinglyLinkedListNode<Character>('F', 'O', 'L', 'L', 'O', 'W', ' ', 'U', 'P');
        deduplicateLinkedList.deduplicate(linkedList);
        
        assertFalse(deduplicateLinkedList.hasDuplicate(linkedList));
        
        char[] actual = new char[linkedList.length()];
        int i = 0;
        for (SinglyLinkedListNode<Character> node : linkedList) {
            actual[i++] = node.data;
        }
        char[] expected = {'F', 'O', 'L', 'W', ' ', 'U', 'P'};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHasDuplicate() {
        SinglyLinkedListNode<Character> linkedList = new SinglyLinkedListNode<Character>('F', 'O', 'L', 'L', 'O', 'W', ' ', 'U', 'P');
        assertTrue(deduplicateLinkedList.hasDuplicate(linkedList));
    }

    @Test
    public void testHasDuplicateForUniqueList() {
        SinglyLinkedListNode<Character> linkedList = new SinglyLinkedListNode<Character>('F', 'O', 'L', 'W', ' ', 'U', 'P');
        assertFalse(deduplicateLinkedList.hasDuplicate(linkedList));
    }

}