package com.quickSelect;

import java.util.Scanner;

public class myPhone {

    public static char[][] phone = {
            {'-'},{},
            {'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i= 0; i<t;i++){
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String result = "";
            result = getRealOutput(str);
            System.out.println(result);
        }
    }

    public static String getRealOutput(String str){
        String result = "";
        char[] strChar = str.toCharArray();
        char lastChar = '*';
        int index = 0;
        int index_ = 0;
        for(char w : strChar){
            if(w=='0') result += '-';
            else{
                if(w=='-'){
                    if(index_<1) index_++;
                    else if(lastChar!='-')result += phone[lastChar-'0'][index%phone[lastChar-'0'].length];
                    index_++;
                }else{
                    if(w!=lastChar){
                        if(lastChar!='-'){
                            result += phone[lastChar-'0'][index%phone[lastChar-'0'].length];
                        }
                    }else{
                        index = index+1;
                    }
                }
            }

            if(w!='-' || index_<2) lastChar = w;
        }
        return result;
    }
}
