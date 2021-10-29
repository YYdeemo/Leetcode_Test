package com.quickSelect;

import java.util.Arrays;
import java.util.Scanner;

public class Gift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();//每个人需要多少个礼物
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();//每种礼物多少钱
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();//每个人的礼物最低价
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            int result = minGiftCost(b, a[i], c[i]);
//            System.out.println("n="+a[i]+" minCost="+c[i]);
            if(i==n-1) System.out.print(result);
            else System.out.print(result+" ");
        }


    }

    public static int minGiftCost(int[] gifts, int n, int minCost){
        int result = -1;
        for (int i = 0; i < gifts.length; i++) {
            if(gifts[i]>=minCost){
                if(i+n>gifts.length) break;
//                System.out.println("now the gift price is "+gifts[i]);
                for (int j = i; j < i+n ; j++) {
                    result += gifts[j];
                }
                break;
            }
        }
        if(result>-1) result += 1;
        return result;
    }
}
