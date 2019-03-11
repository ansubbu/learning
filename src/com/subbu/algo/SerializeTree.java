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

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    
    String serialized = "";
    SNode root;
   
    public void serialize(SNode n) {
        
        Queue q = new LinkedList();
        q.add(n);
        
        while(q.peek() != null) {
            SNode currNode = (SNode)q.remove();
            serialized += currNode.data+" ";
            if (currNode.left != null)
                q.add(currNode.left);
            
            if (currNode.right != null)
                q.add(currNode.right);
        }

        System.out.println("Serialize "+serialized);
    }

    public void add(int value) {
        if(root == null)  
            root = new SNode(value);
        else 
            addToNode(value,root);

    }
    
    public SNode addToNode(int value, SNode node) {
        
        if(value <= node.data) {
            
            if (node.left != null)
                return addToNode(value,node.left);
            else {
                node.left = new SNode(value);
                return node.left;
            }
        } else {
            
            if (node.right != null)
                return addToNode(value,node.right);
            else {
                node.right = new SNode(value);
                return node.right;
            }
        }
     
    }


    public void traverse(SNode n) {

        if(n == null) return;

        traverse(n.left);
        traverse(n.right);
        System.out.print(n.data+" ");
        
    }
    
    
    public static void main(String [] args) {
        SerializeTree data = new SerializeTree();
        data.add(7);
        data.add(14);
        data.add(3);
        data.add(5);
        data.add(11);
        data.add(6);
        data.add(9);
        
        data.traverse(data.root);
        System.out.println();

        data.serialize(data.root);
        
        /*data.add(1);
        data.add(9);
        data.add(2);
        data.add(1);
        data.add(4);
        data.add(17);
        data.add(12);
        data.add(18);
        data.add(16);*/
    
    }
}

class SNode {
    int data;
    SNode left;
    SNode right;
    
    public SNode(int x) {
        this.data = x;
    }
}
