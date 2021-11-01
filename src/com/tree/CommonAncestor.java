package com.tree;

import java.util.*;

/**
 * find the lowest Common Ancestor
 * travel the tree, find a road to the two target
 */
public class CommonAncestor {
    /**
     *
     * @param root root node
     * @param p target node
     * @param q target node
     * @return if p and q in root, then return root; if p or q only one in root, then return this node;
     * if p and q both not in root, then return null;
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }else if(left==null && right==null){
            return null;
        }else{
            return left==null?right:left;
        }
    }



}
