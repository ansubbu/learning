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
public class TwoNumbers {

    public int[] twoSum(int[] nums, int target) {
        
        int [] twoNums = {-1,-1};
        
        if (nums.length < 2) 
            return twoNums;
        
        for ( int i = 0; i < nums.length - 1 ; i++) {
            int firstNum = nums[i];
            twoNums[0] = i;
            int secondNum = target - firstNum;
            for (int j=i+1; j<nums.length;j++) {
                if (nums[j] == secondNum) {
                    twoNums[1] = j;
                    break;
                } 
            }
            if (twoNums[1] != -1) break;
        }
        return twoNums;
    }

    public int[] twoSumBetter(int[] nums, int target) {
        
        int [] twoNums = {-1,-1};
        int i = 0;
        int j = nums.length-1;

        while (i < j) {
            if ( (nums[i]+nums[j]) == target) {
                twoNums[0] = i;
                twoNums[1] = j;
                break;
            } else if(nums[i]+nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return twoNums;
    }

    public static void main (String [] args) {
        TwoNumbers tn = new TwoNumbers();
        //int [] numberList ={1,4,8,3,7,8,19,2,0}; //{1,1};//
        int [] numberList = {0,1,2,3,4,7,8,19};
        int [] indexes = tn.twoSum(numberList, 11);
        int [] indexes1 = tn.twoSumBetter(numberList, 11);
        System.out.println("Sum "+19+ " Indexes "+indexes[0]+" "+indexes[1]);
        System.out.println("Sum "+19+ " Indexes "+indexes1[0]+" "+indexes1[1]);
    }
    
}
