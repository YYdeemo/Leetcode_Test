package com.quickSelect;

import java.util.*;

public class GreedyMethods {

    //priorityQueue
    public static void testPriorityQueue(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.peek());
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int result = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                result ++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return result;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])return (o1[0]-o2[0]);
                else return o1[1]-o2[1];
            }
        });
        int nonOverlaoIntervalsCount = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0]>=end){
                start = intervals[i][0];
                end = intervals[i][1];
                nonOverlaoIntervalsCount++;
            }
        }

        return intervals.length-nonOverlaoIntervalsCount;
    }

    public static int findMinArrowShots(int[][] points) {
        //得到最多数目的完全不重叠的区间范围==至少要这么多只箭的？；
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int key = 1;
//        int start = points[0][0];
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if(points[i][0]>end){
                end = points[i][1];
                key++;
            }
        }
        return key;
    }

    public static int[][] reconstructQueue(int[][] people) {
        //按前面有多少个人从小到大排序 依次判断每一个人应该排在什么位置；
        int[][] queue = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]) return -1;
                else if(o1[1]>o2[1]) return 1;
                else{
                    return o1[0]-o2[0];
                }
            }
        });
        List<int[]> a = new ArrayList<>();
        a.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            //第一个人
            int higher = people[i][1];
            int j = 0,index = 0;
            while(j<higher){
                if(people[i][0]>a.get(index)[0]){
                    index++;
                }else{
                    j++;
                    index++;
                }
            }
            a.add(index,people[i]);

        }
        return a.toArray(new int[a.size()][]);


    }

    public static void main(String[] args) {
        int[][] a = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] b = {{-2,-1},{1,2}};
        System.out.println(findMinArrowShots(b));
//        testPriorityQueue();
    }
}
