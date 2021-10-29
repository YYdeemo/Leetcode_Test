package com.quickSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindKthLargest {

    public static String reverseVowels(String s) {
        String[] a = s.split("");
        int i = 0;
        int j = a.length-1;
        String regx = "a|e|i|o|u|A|E|I|O|U";
        while(i<j){
            while(i<j && !a[i].matches(regx))
                i++;
            while(i<j && !a[j].matches(regx))
                j--;
            if(i<j){
                String temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        String t = "";
        for(String ss : a){
            t += ss;
        }
        return t;

    }
    public static int findKthNumber(int n, int k) {
        int p = 1, cur = 1;
        System.out.println(1);
        while(p<k){

            //有子树
            if(n/cur>=10){
                cur = cur*10;
            }
            //无子树
            else{
                //尾数不是9并且小于n
                if(cur<n && (cur+1)%10!=0){
                    cur += 1;
                }
                //尾数是9或者马上大于n
                else{
                    if((cur+1)%10==0){
                        while(cur/10>=1 && cur%10==9){
                            cur =cur/10;
                        }
                        cur = cur+1;
                    }else{
                        cur = cur/10+1;
                    }
                }
            }
            p++;
            System.out.println(cur);
        }
        return cur;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //count each num's frequency
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int num : nums){
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }

        List<Integer>[] lists = new ArrayList[nums.length+1];
        for(int num : frequency.keySet()){
            int fre = frequency.get(num);
            if(lists[fre]==null){
                lists[fre] = new ArrayList<>();
            }
            lists[fre].add(num);
        }

        int[] result = new int[k];
        int j = 0;
        for(int i =nums.length; i>0;i--){
            if(j>=k) break;
            if(lists[i]!=null){
                for(int t = 0; t<lists[i].size();t++) {
                    if (j < k){
                        result[j] = lists[i].get(t);
                        j++;
                    }
                    else break;
                }
            }
        }

        return result;

    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        //存入到map中，记录频率
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i),frequency.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character>[] buckets = new ArrayList[s.length()+1];
        //按频率高低存入list<>[]数组中
        for(char c : frequency.keySet()){
            int fre = frequency.get(c);
            if(buckets[fre] == null) buckets[fre] = new ArrayList<Character>();
            buckets[fre].add(c);
        }
        char[] result = new char[s.length()];
        int k = 0;
        //按频次存入char[]
        for (int i = s.length(); i > 0 ; i--) {
            if(buckets[i] == null) continue;
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int l = 0; l < i; l++) {
                    result[k++] = buckets[i].get(j);
                }
            }
        }
        //返回字符串
        return new String(result);

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] result  = FindKthLargest.topKFrequent(nums,2);
        for (int a : result){
            System.out.print(" "+a+" ");
        }
    }
}
