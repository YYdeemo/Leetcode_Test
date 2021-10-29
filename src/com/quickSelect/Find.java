package com.quickSelect;


import java.util.Arrays;
import java.util.Scanner;

public class Find {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = maxCount(nums, m);
        System.out.println(result);

    }

    public static int maxCount(int[] nums, int m){
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i]+nums[j]<=m){
                    result++;
                }else{
                    break;
                }
            }
        }

        return result;
    }
}
