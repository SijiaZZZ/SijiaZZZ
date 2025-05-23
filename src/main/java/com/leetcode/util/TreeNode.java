package com.leetcode.util;

/**
 * TreeNode structure.
 */
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;

  TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }
}
