/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author saarumug
 */
public class MyGraph {
    
    GraphNode root;
    Queue<GraphNode> nodeList = new LinkedList<GraphNode>(); 
    
    public void addGraphElement(String data, String target) {
        if (root == null) {
            root = new GraphNode(data);
            //System.out.println(data+" added to root");
            return;
        }

        GraphNode addToThisNode = findCity(target,root);
        if (addToThisNode == null) {
            root.children.add(new GraphNode(data));
            //System.out.println(data+" added to "+root.value);
        } else {
            addToThisNode.children.add(new GraphNode(data));
            //System.out.println(data+" added to "+addToThisNode.value);
        }
    }
    
    public boolean search(String s) {
        GraphNode nodeFound = findCity(s, root);
        return (nodeFound != null);
    }
    
    public GraphNode findCity(String a, GraphNode currNode) {

        
        if (a.equals(root.value)) {
            //System.out.println(root.value);
            return root;
        }

        nodeList.clear();
        nodeList.addAll(root.children);

        while (!nodeList.isEmpty()) {
            GraphNode n = nodeList.remove();
            nodeList.addAll(n.children);
            //System.out.println(n.value);
            if (a.equals(n.value))
                return n;
        }
        
        return null;

    }
    
    
    public void bfTraverse() {
        
        nodeList.clear();
        System.out.println(root.value);
        nodeList.addAll(root.children);

        while (!nodeList.isEmpty()) {
            GraphNode n = nodeList.remove();
            nodeList.addAll(n.children);
            System.out.println(n.value);
        }
    }
    
    public static void main(String[] args) {
        MyGraph mg = new MyGraph();
        mg.addGraphElement("Delhi",null);
        mg.addGraphElement("Mumbai","Delhi");
        mg.addGraphElement("Pune", "Mumbai");
        mg.addGraphElement("Gaziabad", "Delhi");
        mg.addGraphElement("Agra", "Delhi");
        mg.addGraphElement("Noida", "Gaziabad");
        mg.addGraphElement("Nasik", "Pune");
        
        System.out.println("Delhi "+mg.search("Delhi"));
        System.out.println("Gaziabad "+mg.search("Gaziabad"));
        System.out.println("Pune "+mg.search("Pune"));
        System.out.println("Mumbai "+mg.search("Mumbai"));
        System.out.println("Noida"+mg.search("Noida"));
        System.out.println("Chennai "+mg.search("Chennai"));
        System.out.println("Agra "+mg.search("Agra"));
        
        mg.bfTraverse();
        
    }
    
}

class GraphNode {
    
    String value;
    ArrayList<GraphNode> children;
    
    public GraphNode(String data) {
        this.value = data;
        this.children = new ArrayList<GraphNode>();
    }
}


/*
                100
  11            23                  45
1 3 31 32    3 4 11 61         3 4 6 7 8

*/