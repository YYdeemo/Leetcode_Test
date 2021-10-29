package com.tecent;

import java.util.Random;

public class SortArray {

    public int[] sortSolution(int[] nums){
        if(nums.length<=1) return nums;
        quickSort(nums,0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        if(start<end){
            int indexRandom = new Random().nextInt(end-start+1)+start;
            swap(nums,start,indexRandom);
            int pos = partitionSort(nums, start, end);
            quickSort(nums, start, pos-1);
            quickSort(nums, pos+1, end);
        }
    }

    public int partitionSort(int[] nums,int start,int end){
        int target = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<j && nums[j]>=target){
                j--;
            }
            while(i<j && nums[i]<target){
                i++;
            }
            swap(nums,i,j);
        }
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
