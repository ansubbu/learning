/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;

import java.util.ArrayList;
/**
 *
 * @author saarumug
 */
public class ReverseWords {
    public String reverseWords(String s) {

        s = s.trim();
        String[] a = s.split(" ");
        int len = a.length;
        for(int i = 0,j = len-1; i < j; i++,j--)
        {
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return String.join(" ",a);
        
        /*
        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayList<String> words = new ArrayList<String>(st.countTokens());
        
        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        
        String finalString = "" ;
        for (int i = words.size() -1; i >= 0 ; i--) {
            finalString = finalString + words.get(i).trim() + " ";
        }*/

//        return finalString.trim();
    }
    
    public static void main(String args[]) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords("the sky is blue"));
        System.out.println(rw.reverseWords("   the sky is blue   "));
        System.out.println(rw.reverseWords("   the   sky   is   blue   "));
       System.out.println(rw.reverseWords("   + ) __ kd _   blue   "));
    }
    
}
