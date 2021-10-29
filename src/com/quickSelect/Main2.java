package com.quickSelect;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String result = "";
            if(checkPerfectString(str)) result = "YES";
            else result = "NO";
            System.out.println(result);
        }
    }

    public static boolean checkPerfectString(String str){
        if(str.length()<=1) return false;
        char c = str.charAt(0);
        for(int i = 1; i<str.length();i++){
            if(str.charAt(i)!=c) {

                return true;
            }
        }
        return true;


    }
}
