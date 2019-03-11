/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;
import java.lang.Character;
/**
 *
 * @author saarumug
 * 91283472332
 *  2147483648
 */
public class AtoI {
    public int myAtoi(String str) {

        String newString = "";
        int retVal = -1;

        for (int i = 0; i < str.length(); i++) {
            
            char letter = str.charAt(i);
            if (Character.isDigit(letter)) {
                newString += letter;
            } else if (letter == ' ') {
                if (newString.length() > 0) 
                    break;
                else 
                    continue;
            } else if (letter == '-' || letter == '+' ) {
                if (newString.length() > 1) {
                    //retVal = 0;
                    break;
                }
                else 
                    newString += letter;
            } else {
                break;
            }
        }
 
        try {
           if (retVal == -1) retVal  = Integer.parseInt(newString);
        } catch (NumberFormatException nfe) {
            if (newString.length() == 1 && (newString.charAt(0) == '-' || newString.charAt(0) == '+'))
                retVal = 0;
            else if (newString.length() == 0) 
                retVal = 0;
            else if (newString.length() > 1 && !Character.isDigit(newString.charAt(1)))
                retVal = 0;
            else if (newString.length() > 1 && newString.charAt(0) == '-')
                retVal = -2147483648;
            else
                retVal = 2147483647;
        }
        
        //System.out.println("newSting "+newString+" retVal"+retVal);
        
        return retVal;
    }
    
    public static void main(String args[]) {
        AtoI a = new AtoI();
        /*        System.out.println("       -42 ["+a.myAtoi("    -42")+"]");
        System.out.println("4193 with words ["+a.myAtoi("4193 with words")+"]");
        System.out.println("words and 987 ["+a.myAtoi("words and 987")+"]");
        System.out.println("-91283472332 ["+a.myAtoi("-91283472332")+"]");
        System.out.println("       ["+a.myAtoi("        ")+"]");
        System.out.println("+13 ww       ["+a.myAtoi("+13 ww       ")+"]");
        System.out.println("w13 ww       ["+a.myAtoi("w13 ww       ")+"]");*/
        System.out.println("  -0012a42["+a.myAtoi("  -0012a42")+"]");
    }
    
}
