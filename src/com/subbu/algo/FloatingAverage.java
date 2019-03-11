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

import java.util.ArrayList;

public class FloatingAverage {
    
    int[] totals;
    int[] numberList;
    
    public void setNumberList(int [] list) {
        numberList = list;
        totals = new int[list.length];
    }
    
    public int calcFloatingAverage(int k) {

        if (k > totals.length || totals.length == 0) return -1;

        if ( totals[0] == 0 ) { 
            totals[0] = numberList[0];
        }
        
        if (totals[k-1] != 0) {
            System.out.println("Found");
            return totals[k-1]/k;
        }

        System.out.println("calculating");

        for (int i = 1; i < k ; i++ ) {
            totals[i] = totals[i-1] + numberList[i];
        }
        printTotals();
        return totals[k-1]/k;
      
    }

    public static void main(String [] args) {
        FloatingAverage fa = new FloatingAverage();
        fa.setNumberList(new int[]{10,3,5,2,5,1,2,2,3,-3,3,5,6,0});
                                        
        System.out.println(fa.calcFloatingAverage(5)); //5
        System.out.println(fa.calcFloatingAverage(10));//3
        System.out.println(fa.calcFloatingAverage(3)); //6
        System.out.println(fa.calcFloatingAverage(7)); //4
    }
    
    public void printTotals() {
        for(int i = 0; i<totals.length; i++) {
            System.out.print(totals[i]+" ");
        }
        System.out.println();
    }
}
