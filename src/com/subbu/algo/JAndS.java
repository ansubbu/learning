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
public class JAndS {
    
    
    public int numJewelsInStones(String J, String S) {
        
        int numJewels = 0;
        
        if (S == null || J == null) return  numJewels;
        
        for(char s: S.toCharArray()) {
            
            if (J.indexOf(s) > -1 ) {
                numJewels++;
            }
        }
        return numJewels;
    }
    
    public static void main(String [] args) {
        JAndS js = new JAndS();
        System.out.println(js.numJewelsInStones("aA","aaAAsidiksOIKakfAmmmfAAmmma"));
        System.out.println(js.numJewelsInStones("aA","a"));
        System.out.println(js.numJewelsInStones("aA","M"));
        System.out.println(js.numJewelsInStones("aA",""));
        System.out.println(js.numJewelsInStones("aA",null));
        System.out.println(js.numJewelsInStones("",""));
        System.out.println(js.numJewelsInStones(null,"Aasds"));
    }
    
}
