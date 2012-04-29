package com.rhendrikson.algorithmproblems.linkedlists.sumoflinkedlistsstrategy;

import com.rhendrikson.algorithmproblems.linkedlists.SinglyLinkedListNode;

public class RecursiveSumOfLinkedListsStrategy implements SumOfLinkedListsStrategy {

    public SinglyLinkedListNode<Integer> calculateSumForward(
    		SinglyLinkedListNode<Integer> linkedList1, 
    		SinglyLinkedListNode<Integer> linkedList2) {
        if (linkedList1 == null || linkedList2 == null) return null;
        
        if (linkedList1.length() > linkedList2.length()) {
            padWithZeroes(linkedList2, linkedList1.length() - linkedList2.length());
        } else if (linkedList1.length() < linkedList2.length()) {
            padWithZeroes(linkedList1, linkedList2.length() - linkedList1.length());
        }
        
        SinglyLinkedListNode<Integer> result = new SinglyLinkedListNode<Integer>();
        DigitAndCarry digitAndCarry = new DigitAndCarry(0, 0);
        calculateSumForward(result, linkedList1, linkedList2, digitAndCarry);
        return result.next;
    }

    private void padWithZeroes(SinglyLinkedListNode<Integer> linkedList, int zeroes) {
        if (zeroes == 0) return;
        
        int temp = linkedList.data;
        linkedList.data = 0;
        linkedList.next = new SinglyLinkedListNode<Integer>(temp, linkedList.next);
        for (int i = 1; i < zeroes; i++) {
            linkedList.next = new SinglyLinkedListNode<Integer>(0, linkedList.next);
        }
    }
    
    private void calculateSumForward(
            SinglyLinkedListNode<Integer> result,
            SinglyLinkedListNode<Integer> linkedList1,
            SinglyLinkedListNode<Integer> linkedList2,
            DigitAndCarry digitAndCarry
            ) {
        if (linkedList1 == null && linkedList2 == null) return;
        
        if (linkedList1.length() != linkedList2.length()) {
            throw new UnsupportedOperationException("Cannot calculate sum of Linked Lists of different lengths.");
        }
        
        if (linkedList1.next == null) {
            int sum = linkedList1.data + linkedList2.data;
            digitAndCarry.carry = sum / 10;
            digitAndCarry.digit = sum % 10;
            result.next = new SinglyLinkedListNode<Integer>(digitAndCarry.digit, null);
            return;
        }
        
        calculateSumForward(result, linkedList1.next, linkedList2.next, digitAndCarry);
        int sum = linkedList1.data + linkedList2.data + digitAndCarry.carry;
        digitAndCarry.carry = sum / 10;
        digitAndCarry.digit = sum % 10;
        result.next = new SinglyLinkedListNode<Integer>(digitAndCarry.digit, result.next);
        
        if (digitAndCarry.carry > 0 && result.length() == linkedList1.length()) {
            result.next = new SinglyLinkedListNode<Integer>(digitAndCarry.carry, result.next);
        }
    }
    
    private class DigitAndCarry {
        public int digit;
        public int carry;
        
        public DigitAndCarry(int digit, int carry) {
            this.digit = digit;
            this.carry = carry;
        }
    }

    public SinglyLinkedListNode<Integer> calculateSumBackward(
    		SinglyLinkedListNode<Integer> linkedList1, 
    		SinglyLinkedListNode<Integer> linkedList2) {
        if (linkedList1 == null || linkedList2 == null) return null;
        
        SinglyLinkedListNode<Integer> result = new SinglyLinkedListNode<Integer>();
        calculateSumBackward(result, linkedList1, linkedList2, 0);
        return result.next;
    }
    
    private void calculateSumBackward(
            SinglyLinkedListNode<Integer> result,
            SinglyLinkedListNode<Integer> linkedList1,
            SinglyLinkedListNode<Integer> linkedList2,
            int carry
            ) {
        if (linkedList1 == null && linkedList2 == null) return;
        
        if (linkedList1 == null) {
            int sum = linkedList2.data + carry;
            carry = sum / 10;
            int digit = sum % 10;
            result.append(digit);
            calculateSumBackward(result, null, linkedList2.next, carry);
            return;
        }
        
        if (linkedList2 == null) {
            int sum = linkedList1.data + carry;
            carry = sum / 10;
            int digit = sum % 10;
            result.append(digit);
            calculateSumBackward(result, linkedList1.next, null, carry);
            return;
        }
            
        int sum = linkedList1.data + linkedList2.data + carry;
        carry = sum / 10;
        int digit = sum % 10;
        result.append(digit);
        calculateSumBackward(result, linkedList1.next, linkedList2.next, carry);
    }

}
