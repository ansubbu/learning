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
public class IslandsProblem {
 
    int noOfIslands = 0;
    boolean scanned = false;
    int [][] arr;
    int [][] tmpArr;
    int rowCount;
    int colCount;
    
    public void scanForIslands() {

        rowCount = arr.length;
        colCount = arr[0].length;

        copyToTmpArr();
        //tmpArr = arr;
        
        //System.out.println("rows "+rowCount+" cols "+colCount);
        
        if (tmpArr == null && tmpArr.length == 0) 
            return;
            
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                
                if (tmpArr[i][j] == 1) {
                    noOfIslands++;
                    resetJoinedLand(i,j);
                }
            }
        }
        
        scanned = true;
    }

    public void resetJoinedLand(int row, int col) {
        
        if (row < 0 || col < 0 || row >= rowCount || col >= colCount || tmpArr[row][col] == 0)
            return;
        
        tmpArr[row][col] = 0;
        
        resetJoinedLand(row+1,col);
        resetJoinedLand(row,col+1);
        resetJoinedLand(row-1,col);
        resetJoinedLand(row,col-1);
        
        return;
    }
    
    public int addLand(int row, int col) {
        
        if (!scanned) 
            scanForIslands();

        if (row < 0 || col < 0 || row > rowCount || col > colCount) return -1;
     
        System.out.println("arr["+(row-1)+"]["+col+"] "+arr[row-1][col]);
        System.out.println("arr["+row+"]["+(col-1)+"] "+arr[row][col-1]);
        System.out.println("arr["+(row+1)+"]["+col+"] "+arr[row+1][col]);
        System.out.println("arr["+row+"]["+(col+1)+"] "+arr[row][col+1]);
        
        if (arr[row-1][col] != 1 &&
            arr[row][col-1] != 1 &&
            arr[row+1][col] != 1 &&
            arr[row][col+1] != 1)  noOfIslands++;
        
        return noOfIslands;
    }
    
    public void copyToTmpArr() {
        
        tmpArr = new int[rowCount][colCount];
        
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                tmpArr[i][j] = arr[i][j];
            }
        }
    }
    
    public static void main(String[] args) {
        IslandsProblem i = new IslandsProblem();
        i.arr = new int[][] {{1,0,1,1,0,0},
                             {1,0,0,0,0,1},
                             {0,1,0,0,0,0},
                             {1,1,0,1,0,0},
                             {0,1,0,1,0,1}};
        i.scanForIslands();
        System.out.println("No of Islands 6 = "+i.noOfIslands);
       
        System.out.println("added 2,4 No of Islands 7 = "+i.addLand(2,4));
        System.out.println("added 1,4 No of Islands 7 = "+i.addLand(1,4));
        
    }
    
}
