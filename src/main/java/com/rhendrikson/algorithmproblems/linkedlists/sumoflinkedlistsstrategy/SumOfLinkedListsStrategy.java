package com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy;

import com.rhendrikson.algorithmproblems.linkedlists.SinglyLinkedListNode;

public interface SumOfLinkedListsStrategy {

    SinglyLinkedListNode<Integer> calculateSumForward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2);
    SinglyLinkedListNode<Integer> calculateSumBackward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2);
    
}
