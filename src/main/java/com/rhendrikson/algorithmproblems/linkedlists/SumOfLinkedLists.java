package com.rhendrikson.algorithmproblems.linkedlists;

import com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy.IterativeSumOfLinkedListsStrategy;
import com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy.SumOfLinkedListsStrategy;

public class SumOfLinkedLists {
    
    private SumOfLinkedListsStrategy strategy = new IterativeSumOfLinkedListsStrategy();
    
    public void setStrategy(SumOfLinkedListsStrategy strategy) {
        this.strategy = strategy;
    }
    
    public SinglyLinkedListNode<Integer> calculateSumForward(
    		SinglyLinkedListNode<Integer> linkedList1, 
    		SinglyLinkedListNode<Integer> linkedList2) {
        return this.strategy.calculateSumForward(linkedList1, linkedList2);
    }
    
    public SinglyLinkedListNode<Integer> calculateSumBackward(
    		SinglyLinkedListNode<Integer> linkedList1, 
    		SinglyLinkedListNode<Integer> linkedList2) {
        return this.strategy.calculateSumBackward(linkedList1, linkedList2);
    }

}
