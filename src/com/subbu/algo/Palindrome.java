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
public class Palindrome {
    
    public boolean isPalindrome(int number) {
        String strRevNumber = reverseNumber(number);
        String strNumber = ""+number;
        
        return strNumber.equals(strRevNumber);
    }
    
    public String reverseNumber(int number) {
        String n = ""+number;
        
        if (n == null || (n != null && n.length() == 0)) return "";
        
        int i=0;
        int j=n.length()-1;
        char[] letters = n.toCharArray();
        
        while (i <= j) {
            
            char tmp = letters[i];
            letters[i] = letters[j];
            letters[j] = tmp;
            
            i++;
            j--;
        }
        
        return new String(letters);
    }
    
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println("123 0 121 123321 123431 -123");
        System.out.println(p.isPalindrome(123));
        System.out.println(p.isPalindrome(0));
        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(123321));
        System.out.println(p.isPalindrome(123431));
        System.out.println(p.isPalindrome(-123));
    }
    
}
