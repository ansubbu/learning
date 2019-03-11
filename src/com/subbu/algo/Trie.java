/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subbu.algo;

import java.util.HashMap;

/**
 *
 * @author saarumug
 */
public class Trie
{
  TrieNode root = new TrieNode();

  public Trie() {
    root = new TrieNode();
    root.data = '0';
    root.word = false;
    root.parent = null;
  }

  public void addWord(String s) {

    if (searchWord(this.root,s)) return;

    char[] letters = s.toCharArray();
    
    TrieNode addToNode = root;

    for (int i = 0 ; i <letters.length; i++) {
      addToNode = addNode(addToNode, letters[i]);
      addToNode.word = (i == letters.length - 1); 
    }
  }

  public TrieNode addNode(TrieNode currNode, char value) {
      
      HashMap myChildren = currNode.children;
      TrieNode nextNode = (TrieNode)myChildren.get(new Character(value));
      
      if( nextNode == null) {
          nextNode = new TrieNode();
          nextNode.parent = currNode;
          nextNode.data = value;
          myChildren.put(new Character(value), nextNode);
      }
      
      return nextNode;
  } 

  public boolean findWord(String s) {
      return this.searchWord(root, s);
  }
  
  public boolean searchWord(TrieNode nodeToSearch, String s) {
    
      boolean wordFound = false;
      if (s.length() == 0) {
          return nodeToSearch.word;
      } else {
        char firstChar = s.charAt(0);
        TrieNode currNode = null;
        if (nodeToSearch.children != null)
              currNode = (TrieNode)nodeToSearch.children.get(new Character(firstChar));

        if(currNode == null) {
            wordFound = false;
        } else {
            String remaining = s.substring(1);
            wordFound = searchWord(currNode,remaining);
        }

        return wordFound;
      }
  }
  
  public static void main(String[] args) {
      Trie trie = new Trie();
      trie.addWord("advantage");
      trie.addWord("add");
      trie.addWord("apple");
      trie.addWord("able");
      trie.addWord("zebra");
      trie.addWord("zen");
      trie.addWord("zip");
      System.out.println("advantage " + trie.findWord("advantage"));
      System.out.println("adv " + trie.findWord("adv"));
      System.out.println("add " + trie.findWord("add"));
      System.out.println("apple " + trie.findWord("apple"));
      System.out.println("able " + trie.findWord("able"));
      System.out.println("zebra " + trie.findWord("zebra"));
      System.out.println("zen " + trie.findWord("zen"));
      System.out.println("zip " + trie.findWord("zip"));
      System.out.println("zipper " + trie.findWord("zipper"));
      System.out.println("zeb " + trie.findWord("zeb"));
      
  }
  
}

class TrieNode
{
  char data;
  HashMap children = new HashMap();  
  boolean word;
  TrieNode parent;
}
