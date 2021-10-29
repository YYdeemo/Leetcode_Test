package com.quickSelect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int sumOfUnique (int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer,Boolean>();
        int result = 0;
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,true);
            }else{
                map.put(n,false);
            }
        }
        for(Integer key : map.keySet()){
            result += map.get(key)?0:key;
        }
        return result;

        // write code here
    }

    public static int[] dailyTemperatures (int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        result[size-1] = 0;
        if(temperatures.length<2) return result;
        for(int i = size-2; i>=0;i--){
            if(temperatures[i]<temperatures[i+1]) result[i] = 1;
            else{
                boolean never = false;
                int index = result[i+1]+i+1;
                while(index<size && temperatures[i]>temperatures[index]){
                    System.out.println("tem[i]"+temperatures[i]+"index = "+index+" tem[index]="+temperatures[index]);
                    if(result[index]==0){
                        result[i] = 0;
                        never = true;
                        break;
                    }
                    index += result[index];
                }
                if(!never && index<size && temperatures[index]>temperatures[i]) result[i] = index-i;
                else result[i] = 0;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] result;
        result = dailyTemperatures(nums);
        for (int n:result) {
            System.out.print(n+" ");
        }
    }

    public static int minDelete(String str){
        str = str.substring(2,str.length()-2);
        String[] strArrays = str.split(", ");
        int[][] intArrays = new int[strArrays.length][2];
        int t = 0;
        for(String ss : strArrays){
            ss = ss.substring(1,4);
            intArrays[t][0] = Integer.parseInt(ss.split(",")[0]);
            intArrays[t][1] = Integer.parseInt(ss.split(",")[1]);
            t++;
        }
        char c ='c';
        String result = "";
        result+= c;
        Arrays.sort(intArrays, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0])return -1;
                else if(o1[0]>o2[0]) return 1;
                else{
                    if(o1[1]<o2[1]) return -1;
                    else return 1;
                }
            }
        });
        for(int i = 0;i< intArrays.length;i++){
            System.out.println(intArrays[i][0]+", "+intArrays[i][1]);
        }
        int start = intArrays[0][0];
        int end = intArrays[0][1];
        int count = 0;
        for(int i =1;i<intArrays.length;i++){
            if(intArrays[i][0]==start) count++;
            else{
                if(end <= intArrays[i][0]){
                    start = intArrays[i][0];
                    end = intArrays[i][1];
                }else{
                    count++;
                }
            }
        }
        return count;
    }

    public static int maxBucket(int n){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 1; i<=n;i++ ){
            int indexSum = 0;
            int x = i;
            while(x/10>=1){
                indexSum += x%10;
                x = x/10;
            }
            indexSum += x;
            map.put(indexSum,map.getOrDefault(indexSum,0)+1);
        }
        HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
        int maxCount = 0;
        for(int key : map.keySet()){
            int value = map.get(key);
            if(!result.containsKey(value)) result.put(value,0);
            result.put(value,result.getOrDefault(value,0)+1);
            maxCount = maxCount>value?maxCount:value;
        }
        return result.get(maxCount);
    }

    public static int minChangeNumber(int a, int b){
        int reduce = Math.abs(a-b);
        int t = 1;
        boolean isok = false;
        while (true){
            int sumT = sumT(t);
            int sub = sumT-reduce;
            if(sub>=0 && sub%2==0 && (sumT-reduce)/2<t){
                break;
            }
            t++;
        }
        return t;
    }

    public static int sumT(int t){
        return t*(t+1)/2;

    }
}
