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
import java.util.List;

public class Spiral {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> spiralList = new ArrayList<Integer>();
        
        int spiralCount = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        if (rows <= columns) spiralCount = rows/2;
        else spiralCount = columns/2;

        for (int sc = 0; sc < spiralCount ; sc++)
        {
            for (int c=sc; c < columns-sc; c++ )
                spiralList.add(new Integer(matrix[sc][c]));

            for (int c=sc+1; c < rows-sc; c++ ) 
                spiralList.add(new Integer(matrix[c][columns-1-sc]));
            
            for (int c=columns-sc-2; c > sc; c-- ) 
                spiralList.add(new Integer(matrix[rows-1-sc][c]));

            for (int c=rows-1-sc; c > sc ; c-- ) 
                spiralList.add(new Integer(matrix[c][sc]));
        }
 
        return spiralList;
    }
 
    public static void main(String[] args) {
        /*int [][] spiral = {{1,2,3,4},
                           {10,11,12,5},
                           {9,8,7,6}};*/
       int [][] spiral = {{1,2,3,4,5,6}};
       
/*{{1,   2,  3,  4, 5, 6, 7},
{18, 19, 20, 21,22,23, 8},
{17, 28, 27, 26,25,24, 9},
{16, 15, 14, 13,12,11,10}};

{
{1,   2,  3,  4},
{16, 17, 18,  5},
{15, 24, 19,  6},
{14, 23, 20,  7},
{13, 22, 21,  8},
{12, 11, 10,  9}
};*/

        for (int i=0; i<3; i++)
            for(int j=0; j<4; j++)
                System.out.print(spiral[i][j]+" ");
        System.out.println();
        Spiral s = new Spiral();
        s.spiralOrder(spiral);
        
    }
    
}
