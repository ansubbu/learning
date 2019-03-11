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
public class Btree {
    
    Node root;
    ArrayList<Node> range;
    
    public void add(int value) {
        addToTree(root,value);
    }
    
    public void addToTree(Node currNode, int value) {
 
        if (root == null) {
            root = new Node(value);
            return;
        }
        
        if (value <= currNode.data) {
            if (currNode.left != null) 
                addToTree(currNode.left,value);
            else {
                currNode.left = new Node(value);
            }
        } else {
            if (currNode.right != null) 
                addToTree(currNode.right,value);
            else {
                currNode.right = new Node(value);
            }
        }
    }
    
    public boolean find(int value) {
        
        boolean found = findInTree(root,value);
        return found;
    }
    
    public boolean findInTree(Node currNode, int value) {

        if (currNode.data == value) return true;

        if (value <= currNode.data) {
            if (currNode.left != null)
                return findInTree(currNode.left,value);
        } else {
            if (currNode.right != null) 
                return findInTree(currNode.right,value);
        }

        return false;
               
    }
    
    public void traverse(Node currNode, int mode) {

        if (currNode == null) return;
        
        if (mode == 1) {
            System.out.print(currNode.data+ " ");
            traverse(currNode.left,mode);
            traverse(currNode.right,mode);
        } else if (mode == 2) {
            traverse(currNode.left,mode);
            System.out.print(currNode.data+ " ");
            traverse(currNode.right,mode);
        } else if (mode == 3) {
            traverse(currNode.left,mode);
            traverse(currNode.right,mode);
            System.out.print(currNode.data+ " ");
        }
    }

    public void inOrderTraverse(Node currNode,int from, int to) {
        
        if (currNode == null) return;
        
        inOrderTraverse(currNode.left,from,to);
        if (from <= currNode.data && currNode.data <= to) range.add(currNode);
        inOrderTraverse(currNode.right,from,to);
    }
    
    public void getRange(int from, int to) {
        
        range = new ArrayList<Node>();
        
        inOrderTraverse(root,from,to);
    }
    
    public static void main(String[] args) {

        Btree data = new Btree();
        data.add(7);
        data.add(14);
        data.add(3);
        data.add(5);
        data.add(11);
        data.add(6);
        data.add(9);
        data.add(1);
        data.add(9);
        data.add(2);
        data.add(1);
        data.add(4);
        data.add(17);
        data.add(12);
        data.add(18);
        data.add(16);

        data.traverse(data.root, 1);
        System.out.println();
        data.traverse(data.root, 2);
        System.out.println();
        data.traverse(data.root, 3);
        System.out.println();
/*
        System.out.println("1 "+data.find(1));
        System.out.println("8 "+data.find(8));
        System.out.println("9 "+data.find(9));
        System.out.println("10 "+data.find(10));
        System.out.println("25 "+data.find(25));
        System.out.println("-1 "+data.find(-1));
      
        data.getRange(3,7);
       
        for(Node n : data.range) {
            System.out.print(n.data+" ");
        }
        System.out.println();
         
        data.getRange(5,22);

        for(Node n : data.range) {
            System.out.print(n.data+" ");
        }
        */
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int value)  {
        this.data = value;
    }
}