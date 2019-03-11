/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
 */
package com.subbu.algo;

/**
 *
 * @author saarumug
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
      
      String temp = "";
      
      if (s == null) return false;
      
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') 
              temp += s.charAt(i);
          
          if (temp.length() > 0) {
              if ((s.charAt(i) == '}') && (temp.charAt(temp.length()-1) == '{' )
                  || (s.charAt(i) == ')') && (temp.charAt(temp.length()-1) == '(' )
                  || (s.charAt(i) == ']') && (temp.charAt(temp.length()-1) == '[' )) {
                      temp = temp.substring(0,temp.length()-1);
              }
          }
      }

      return (temp.length() == 0);
    }
    
    public static void main(String [] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(" {[()]} "+vp.isValid("{[()]}"));
        System.out.println("  "+vp.isValid(""));
        System.out.println(" {()]} "+vp.isValid("{)}"));
        System.out.println(" {ss[dd(ff)gg]ss} "+vp.isValid("{ss[dd(ff)gg]ss}"));
        System.out.println(" {[)(]} "+vp.isValid("{[)(]}"));
        System.out.println(" {{}} "+vp.isValid("{{}}"));
        System.out.println(" )]}{[( "+vp.isValid(")]}{[("));
        System.out.println(" {([}]) "+vp.isValid("{([}])"));
        System.out.println(" (((((((() "+vp.isValid("(((((((()"));
        System.out.println(" ((()(()))) "+vp.isValid("((()(())))"));
        System.out.println(" null "+vp.isValid(null));
        
    }
}
