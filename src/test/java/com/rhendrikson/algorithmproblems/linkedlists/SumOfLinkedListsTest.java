package com.rhendrikson.algorithmproblems.linkedlists;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy.IterativeSumOfLinkedListsStrategy;
import com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy.RecursiveSumOfLinkedListsStrategy;
import com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy.SumOfLinkedListsStrategy;

@RunWith(Parameterized.class)
public class SumOfLinkedListsTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new IterativeSumOfLinkedListsStrategy() },
            { new RecursiveSumOfLinkedListsStrategy() }
        });
    }
    
    private SumOfLinkedLists sumOfLinkedLists;
    
    public SumOfLinkedListsTest(SumOfLinkedListsStrategy strategy) {
        sumOfLinkedLists = new SumOfLinkedLists();
        sumOfLinkedLists.setStrategy(strategy);
    }
    
    @Test
    public void testCalculateSumBackward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<Integer>(7, 1, 6);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<Integer>(5, 9, 2);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<Integer>(2, 1, 9);
        assertEquals(expected, sumOfLinkedLists.calculateSumBackward(linkedList1, linkedList2));
    }

    @Test
    public void testCalculateSumForward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<Integer>(6, 1, 7);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<Integer>(2, 9, 5);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<Integer>(9, 1, 2);
        assertEquals(expected, sumOfLinkedLists.calculateSumForward(linkedList1, linkedList2));
    }
    
    @Test
    public void testCalculateSumBackwardWithDifferentLengths() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<Integer>(7, 1, 6);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<Integer>(5, 9);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<Integer>(2, 1, 7);
        assertEquals(expected, sumOfLinkedLists.calculateSumBackward(linkedList1, linkedList2));
    }

    @Test
    public void testCalculateSumForwardWithDifferentLengths() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<Integer>(6, 1, 7);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<Integer>(9, 5);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<Integer>(7, 1, 2);
        assertEquals(expected, sumOfLinkedLists.calculateSumForward(linkedList1, linkedList2));
    }

}