package com.quickSelect;

import java.util.*;

public class GoldEgg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strList = str.split(" ");
        int size = strList.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> mapR = new HashMap<>();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(strList[i]);
            nums[i] = n;
            if(!mapR.containsKey(n)) mapR.put(n, new LinkedList<Integer>());
            mapR.get(n).add(i);
            map.put(i,n);
        }
//        Arrays.sort(nums);
        int result = 1;
        int len = 0;
        int nIndex = size/2-1;
        boolean isok = size%2==0;
        System.out.println("error:"+9/2);
        for (int i = 0; i < size; i++) {
            System.out.println(nIndex);
            if(isok) nIndex = len%2==0?nIndex+len:nIndex-len;
            int n = nums[nIndex];
            int nLeft = getLeftIndex(map, nIndex, true,size);
            int nRight = getLeftIndex(map,nIndex,false, size);
            result += n*nLeft*nRight;
            map.remove(nIndex);
//            mapR.get(n).removeFirst();
        }
        System.out.println(result);

    }

    public static int getLeftIndex(HashMap<Integer,Integer> map, int nIndex, boolean leftTrue, int size){
        if(leftTrue) {
            nIndex -= 1;
            while (!map.containsKey(nIndex)) {
                nIndex -= 1;
                if(nIndex<0) return 1;
            }
            return map.get(nIndex);
        }else{
            nIndex += 1;
            while(!map.containsKey(nIndex)) {
                nIndex += 1;
                if(nIndex>size-1) return 1;
            }
            return map.get(nIndex);
        }
    }
}
