package com.quickSelect;

class Node{
    int val;
    Node next;
    public Node(){}
}

public class CycleList {

    public static void main(String[] args) {

    }

    public static boolean isCycle(Node node){
        if(node==null) return false;
        Node p = node;
        Node q = node.next;
        while(p != null && q !=null){
            if(p==q) return true;
            p = p.next;
            q = q.next.next;

        }
        return false;
    }
}
