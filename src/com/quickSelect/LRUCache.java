package com.quickSelect;

import javafx.util.Pair;

import java.util.*;

public class LRUCache {
    class Pair {
        int key;
        int value;
        public Pair(int key , int  value){this.key = key;this.value = value;}

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Pair) {
                if (key!=((Pair) obj).key) return false;
                if (value != ((Pair) obj).value) return false;
                return true;
            }
            return false;
        }
    }

    int capacity;
    LinkedList<Pair> list;
    Hashtable<Integer, Integer> table;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        table = new Hashtable<Integer,Integer>();
    }

    public int get(int key) {
        if(table.containsKey(key)){
            int value = table.get(key);
            list.remove(new Pair(key,value));
            list.addLast(new Pair(key,value));
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(table.size()==capacity){
            table.remove(list.getFirst().key);
            list.remove(0);
            table.put(key,value);
            list.addLast(new Pair(key,value));
        }else{
            table.put(key,value);
            list.addLast(new Pair(key,value));
        }
    }


}
