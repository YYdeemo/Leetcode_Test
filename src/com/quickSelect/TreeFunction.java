package com.quickSelect;

import java.util.*;

public class TreeFunction {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean toRight = true;
    LinkedList<TreeNode> levelNodes = new LinkedList<TreeNode>();

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
////        List<List<Integer>> result = new ArrayList<>();
////        levelNodes.add(root);
////        result.add(new ArrayList<>(Arrays.asList(root.val)));
////        while(levelNodes.size()>0){
////            levelNodes.offer();
////            levelNodes.addLast();
////        }
//        return result;
//    }
}
