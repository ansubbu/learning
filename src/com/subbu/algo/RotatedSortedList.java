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
public class RotatedSortedList {
    
    public boolean isSortedRotated(int[] a) {
        
        if (a == null || a.length == 0) return false;
        
        int smallest = a[0];
        int smallestInd = 0;
        
        for (int i=0; i < a.length-1; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
                smallestInd = i;
            }
        }
        
        boolean rightSorted = true;
        for (int i = smallestInd; i < a.length-2; i++)
            rightSorted = a[i] < a[i+1];

        boolean leftSorted = true;
        for (int i = smallestInd-1; i > 0; i--)
            leftSorted = a[i] > a[i-1];
        
        boolean chained = a[0] > a[a.length-1];
        
        return rightSorted && leftSorted && chained;
    }
    
    public static void main(String[] args) {
        RotatedSortedList rs = new RotatedSortedList();
        //System.out.println("true "+rs.isSortedRotated(new int []{4,5,6,1,2,3}));
        //System.out.println("false "+rs.isSortedRotated(new int []{4,5,6,1,2,7}));
        //System.out.println("true "+rs.isSortedRotated(new int []{4,5,-6,1,2,3}));
        System.out.println("false "+rs.isSortedRotated(new int []{4,-5,6,1,2,3}));
        //System.out.println("true "+rs.isSortedRotated(new int []{-3,-2,0,1,-6,-5,-4}));
        //System.out.println("false "+rs.isSortedRotated(new int []{}));
        //System.out.println("false "+rs.isSortedRotated(null));
    }
    
    
}
