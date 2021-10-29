package com.quickSelect;

import com.sun.tools.classfile.Opcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SubString {


    public static void main(String[] args) {
        String str = "helloword";
        String[] dict = {"hell","hello","word"};
        HashSet<String> set = new HashSet<>();
        for(String ss : dict){
            set.add(ss);
        }
        System.out.println(findInDict(str,set,0,1));
    }

    public static boolean findInDict(String str, HashSet<String> dict, int start, int end){
        String subString = str.substring(start,end+1);
        if(dict.contains(subString)){
            if(end==str.length()-1) return true;
            else {
                start = end + 1;
                end += 1;
                return findInDict(str, dict, start, end);
            }
        }else{
            if(end==str.length()-1) return false;
            else{
                end += 1;
                return findInDict(str,dict,start,end);
            }
        }
    }

    public static boolean findString(String str, String[] dict){
        HashMap<Character, LinkedList<String>> map = new HashMap<>();
        for(String ss : dict){
            char w = ss.charAt(0);
            if(!map.containsKey(w)) map.put(w,new LinkedList<String>());
            map.get(w).add(ss);
        }
        while(str.length()>0){
            char w = str.charAt(0);
            if(map.containsKey(w)){
                for(String ss : map.get(w)){
                    if(str.contains(ss)){
                        str = str.replaceAll(ss,"");
                        continue;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
