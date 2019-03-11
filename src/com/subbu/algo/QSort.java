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

public class QSort {

    int counter;
    
    public int[] sort(int[] a, int low, int high){
        
        counter++;
        //base case
        if(high<=low){
        } else { 
            int pivot = a[low]; 
            int i = low+1; int tmp; 

            //partition array 
            for(int j = low+1; j<= high; j++){
                if(a[j]<pivot){
                    tmp = a[j]; 
                    a[j] = a[i]; 
                    a[i] = tmp; 
                    
                System.out.print("a["+i+"]="+a[i]+":a["+j+"]="+a[j]+":pivot="+pivot+":low="+low+":high="+high);
                printarray(a);
                    
                    i++; 
                }

            }

            //put pivot in right position
            a[low] = a[i-1]; 
            a[i-1] = pivot; 
            System.out.print("a["+(i-1)+"]="+a[i-1]+":pivot="+pivot+":low="+low+":high="+high);
            printarray(a);

            //call qsort on right and left sides of pivot
            sort(a, low, i-2); 
            sort(a, i, high); 
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        QSort qs = new QSort();
        int[] sortThis = {3,1,7,2,5,0};
        qs.printarray(sortThis);
        System.out.println("Start here....");
        qs.sort(sortThis, 0, sortThis.length-1);
        System.out.println("End here....");
        qs.printarray(sortThis);
        
    }
    
    public void printarray(int[] a) {
        System.out.print(":counter="+counter+":");
        for (int i=0; i < a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    
}
