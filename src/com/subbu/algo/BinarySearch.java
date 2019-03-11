/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;

/**
 *   3
 *   1 3 4 5 6 8 9
 * @author saarumug
 */
public class BinarySearch {
    public boolean search(int[] searchList, int searchItem) {
        if (searchList == null || searchList.length == 0) 
            return false;
        
        return search(searchList,0,searchList.length-1, searchItem);
    }
    
    public boolean search(int[] searchList, int left, int right, int searchItem) {

        if (left <= right) {
        
            int mid = left+(right-left)/2;

            if (searchList[mid] == searchItem)
                return true;

            if(searchList[mid] > searchItem) {
                return search(searchList,left,mid-1,searchItem);
            } else {
                return search(searchList,mid+1,right,searchItem);
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int[] sortedList = {-9,-1,0,8,9,10,15,21};
        BinarySearch s = new BinarySearch();
        
        System.out.println(" 1 "+s.search(sortedList,1));
        System.out.println(" -1 "+s.search(sortedList,-1));
        System.out.println(" 0 "+s.search(sortedList,0));
        System.out.println(" 21 "+s.search(sortedList,21));
        System.out.println(" null list "+s.search(null,21));
        System.out.println(" empty list "+s.search(new int[]{},21));
        
    }
}
