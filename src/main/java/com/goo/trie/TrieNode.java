package com.goo.trie;

/**
 * TrieNode structure.
 */
public class TrieNode {

  TrieNode[] children = new TrieNode[26];
  String word;
  TrieNode() {
  }
}
