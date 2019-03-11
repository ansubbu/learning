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
public class SumSubarray {
    
    public int noOfSumSubArray(int[] arr, int k) {
        
        int sum = 0;
        int[] sumarr = new int[arr.length];
        sumarr[0] = 0;
        
        for (int i = 1; i < arr.length-1; i++) {
            sumarr[i] = sumarr[i-1] + arr[i-1];
        }

        for (int start=0; start<arr.length-2; start++){
            for (int end=start+1; end < arr.length-1; end++) {
                if (sumarr[end] - sumarr[start] == k) {
                    System.out.print(start+","+end+":");
                    sum++;
                }
            }
        }
        System.out.println();
        return sum;
    }

    
    public static void main(String[] args) {
        SumSubarray ss = new SumSubarray();
        int [] arr = {-1,9,0,3,9,-12,8,0,31,-30,22};
        
        System.out.println("number of subarrays adding up to 8:" + ss.noOfSumSubArray(arr, 8));
    }
    
}
