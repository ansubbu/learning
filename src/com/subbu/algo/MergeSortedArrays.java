/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;

/**
 *
 * @author saarumug
 */
public class MergeSortedArrays {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        if (l1 == null) {    
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } */
        
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
    
    
    public static void main(String [] ars) {
        
        MergeSortedArrays ma = new MergeSortedArrays();
        
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(7);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        ListNode node25 = new ListNode(5);
        ListNode node26 = new ListNode(6);
        ListNode node27 = new ListNode(7);
        ListNode node28 = new ListNode(8);
        ListNode node29 = new ListNode(9);
        ListNode node30 = new ListNode(10);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;
        node28.next = node29;
        node29.next = node30;
        
        System.out.println("Lists added");
        
        ListNode curr = node11;
        while(curr != null)
        {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("Lists 1 printed");
        
        curr = node21;
        while(curr != null)
        {
            System.out.print(curr.val+" ");
            curr = curr.next;
        } 
        
        System.out.println();
        System.out.println("Lists 2 printed");
        
        ListNode curr1 = ma.mergeTwoLists(node11,node21);
        while(curr1 != null)
        {
            System.out.print(" "+curr1.val);
            curr1 = curr1.next;

        }
    }

}

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }