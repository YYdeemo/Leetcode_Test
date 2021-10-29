package com.tecent;

import java.util.Scanner;

public class MaxJumpSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int length = sc.nextInt();
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j] = sc.nextInt();
            }
            int result = getMaxSum(nums);
            System.out.println(result);
        }
    }

    public static int getMaxSum(int[] nums){
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int sum = 0;
            while(index < nums.length){
                sum += nums[index];
                index += nums[index];
            }
            maxSum = maxSum>sum ? maxSum : sum;
        }
        return maxSum;
    }
}
