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
public class WaysToClimb {
    
    public long numberWaysToClimb(int steps, int skips) {
        
        long[] waysToClimb;
        if (steps > 1)
             waysToClimb = new long[steps+2];
        else {
            return 1;
        }
        
        waysToClimb[0] = 1;
        waysToClimb[1] = 1;
        waysToClimb[2] = 2;

        if (skips == 3) {
            for(int i = 3; i <= steps; i++)
                waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2] + waysToClimb[i-3];
        } else if (skips == 2) {
            for(int i = 2; i <= steps; i++) 
                waysToClimb[i] = waysToClimb[i-1] + waysToClimb[i-2];
        }
      
        return waysToClimb[steps];
    } 
    
    public static void main(String[] args) {
        WaysToClimb wtc = new WaysToClimb();
        
        for (int i=0; i < 10; i++) {
          System.out.println(i+","+wtc.numberWaysToClimb(i,2)+","+wtc.numberWaysToClimb(i,3));
        }
    }
}
