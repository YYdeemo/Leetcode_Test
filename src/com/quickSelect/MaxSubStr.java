package com.quickSelect;

import java.util.HashSet;
import java.util.Set;

public class MaxSubStr {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> subStr = new HashSet<Character>();
        int rk = -1;
        for(int i = 0; i < s.length(); i++){
            if(i!=0){
                subStr.remove(s.charAt(i));
            }
            while(rk+1<s.length() && !subStr.contains(s.charAt(rk+1))){
                subStr.add(s.charAt(rk+1));
                rk++;
            }
            maxLength = maxLength>subStr.size() ? maxLength : subStr.size();
        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println("result = "+lengthOfLongestSubstring(" "));
    }
}
