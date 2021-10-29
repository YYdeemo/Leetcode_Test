package com.quickSelect;

import sun.awt.image.ImageWatched;

import java.util.*;

public class findSigma {

    public static HashMap<Integer, LinkedList<Integer>> edges;
    public static LinkedList<Integer> sigma;
    public static LinkedList<LinkedList<Integer>> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        edges = new HashMap<>();
        result = new LinkedList<>();
        for(int i = 0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!edges.containsKey(x)) edges.put(x,new LinkedList<Integer>());
            if(!edges.containsKey(y)) edges.put(y,new LinkedList<Integer>());
            edges.get(x).add(y);
            edges.get(y).add(x);
        }
        System.out.println(findSigmaMethod(n));

    }
    public static int findSigmaMethod(int n){
        if(n<5) return 0;
        for(Integer start : edges.keySet()){
            sigma = new LinkedList<Integer>();
            sigma.add(start);
            System.out.println("sigma add "+start);
            sigma(start);
        }
        return result.size();
    }

    public static boolean check(LinkedList<Integer> list){
        if(result.size()==0) return true;
        for(LinkedList<Integer> l : result){
            if(l.containsAll(list)) return false;
        }
        return true;
    }

    public static void sigma(int v){
        LinkedList<Integer> list = edges.get(v);
        if(list==null) return;
        for(Integer w : list){
            if(!sigma.contains(w)){
                sigma.add(w);
                System.out.println("sigma add "+w);
                if(sigma.size()==5){
                    System.out.println("success!");
                    if(check(sigma)){
                        LinkedList<Integer> l = new LinkedList<>(sigma);
                        result.add(l);
                    }
//                    sigma.pop();
                    System.out.println("sigma pop "+sigma.removeLast());
                }
                else sigma(w);
            }else{
                continue;
            }
        }
        sigma.removeLast();
    }
}
