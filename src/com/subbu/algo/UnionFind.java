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
public class UnionFind {

    int [] uflist;

    public UnionFind(int size) {
        
        uflist = new int[size];
        for (int i =0; i < size; i++) {
           uflist[i] = i;
        }
    }

    public void qkradd(int a, int b) {

        for (int i=0; i < uflist.length ; i++) {
            System.out.print(uflist[i]+" ");
        }
        System.out.println();
    }

    public boolean qkrconnected(int a, int b) {

        return false;
    }
    
    
    public int getRoot(int a) {
        int root = uflist[a];
        while(root != uflist[root]) root = uflist[root];

        return root;
    }
    
    public void qadd(int a, int b) {

        int roota = getRoot(a);
        int rootb = getRoot(b);

        uflist[roota] = uflist[rootb];

        for (int i=0; i < uflist.length ; i++) {
            System.out.print(uflist[i]+" ");
        }
        System.out.println();
    }

    public boolean qconnected(int a, int b) {
        
        int roota = a; 
        int rootb = b;
        int tempIndex = a;

        while(tempIndex != uflist[tempIndex]) {
            
            if (uflist[tempIndex] == b) return true;
            
            tempIndex = uflist[tempIndex];
            roota = tempIndex;
        }

        tempIndex = b;
        while(tempIndex != uflist[tempIndex]) {
            
            if (uflist[tempIndex] == a) return true;
            
            tempIndex = uflist[tempIndex];
            rootb = tempIndex;
        }

        return (roota == rootb);
    }        

    public boolean connected(int a, int b) {
        return (uflist[a] == uflist[b]);
    }
    
    public void slowadd(int a, int b) {
        int ida = uflist[a];
        int idb = uflist[b];
        
        for (int i=0; i < uflist.length ; i++) {
            if (uflist[i] == idb) uflist[i] = ida;
        }

        for (int i=0; i < uflist.length ; i++) {
            System.out.print(uflist[i]+" ");
        }
        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(12);
        uf.slowadd(4,3);
        uf.slowadd(3,8);
        uf.slowadd(6,5);
        uf.slowadd(9,4);
        uf.slowadd(2,1);
        uf.slowadd(8,9);
        uf.slowadd(5,4);
        uf.slowadd(5,0);
        uf.slowadd(7,2);
        uf.slowadd(6,1);
        uf.slowadd(7,3);
        System.out.println("3,7" + uf.connected(3, 7));
        System.out.println("3,6" + uf.connected(3, 6));
        System.out.println("4,5" + uf.connected(4, 5));
        System.out.println("8,4" + uf.connected(8, 4));
        System.out.println("3,8" + uf.connected(3, 8));
        System.out.println("1,6" + uf.connected(1, 6));        

        UnionFind quf = new UnionFind(12);
        quf.qadd(4,3);
        quf.qadd(3,8);
        quf.qadd(6,5);
        quf.qadd(9,4);
        quf.qadd(2,1);
        quf.qadd(8,9);
        quf.qadd(5,4);
        quf.qadd(5,0);
        quf.qadd(7,2);
        quf.qadd(6,1);
        quf.qadd(7,3);

        System.out.println("3,7" + quf.qconnected(3, 7));
        System.out.println("3,6" + quf.qconnected(3, 6));
        System.out.println("4,5" + quf.qconnected(4, 5));
        System.out.println("8,4" + quf.qconnected(8, 4));
        System.out.println("3,8" + quf.qconnected(3, 8));
        System.out.println("1,6" + quf.qconnected(1, 6));
    }

}
