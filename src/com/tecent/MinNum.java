package com.tecent;

import java.util.Scanner;

public class MinNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t;i++){
            int x = sc.nextInt();
            int result = getMinNum(x);
            System.out.println(result);
        }
    }

    public static int getMinNum(int x){
        int t1 = 1;
        int t2 = minSpecialNum(x+1);
        int t3 = minSpecialNum(t2+x);
//        System.out.println("they are "+t2+" "+t3);
        return t2*t3;
    }

    public static int minSpecialNum(int x){
        boolean isok = true;
        boolean end = false;
        while(!end) {
            int sqrt = (int)Math.sqrt(x);
            int i = 2;
            while (i <= sqrt) {
                if (x % i == 0) {
                    isok = false;
                    break;
                }
                i++;
            }
            if(isok==true) end = true;
            else{
                x++;
                isok = true;
            }
        }
        return x;
    }
}
