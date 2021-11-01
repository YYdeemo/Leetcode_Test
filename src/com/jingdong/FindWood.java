package com.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一排木头，一个人从最左找，一个人从最右找，我知道所有木头的长度，
 * 在我的指挥下他们最少查看多少根木头可以找到最短的和最长的
 *
 * tip：找到最小值和最大值的位置
 */
public class FindWood {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = minFindCount(nums);
        System.out.println(result);
    }

    public static int minFindCount(int[] nums){
        int result = 0;
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int min = numsClone[0];
        int max = numsClone[nums.length-1];
        int minC = 9999,maxC = 9999;
        boolean minL = true,maxL = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==min){
                int minCNew = Math.min(i + 1, nums.length - i);
                minC = Math.min(minCNew, minC);
                if(i>=nums.length/2) minL = false;
            }
            if(nums[i]==max){
                int maxCNew = Math.min(i + 1, nums.length - i);
                maxC = Math.min(maxCNew, maxC);
                if(i>=nums.length/2) maxL = false;
            }
        }
        if(maxL==minL){
            result = Math.max(minC, maxC);
        }else{
            result = minC+maxC;
        }
        return result;
    }
}
