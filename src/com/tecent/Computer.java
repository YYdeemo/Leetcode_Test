package com.tecent;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer {

    public static ArrayList<Integer> integers = new ArrayList<>();
    public static ArrayList<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] integerStr = str.split("[x|@|+]");
        for (String in : integerStr) {
            integers.add(Integer.parseInt(in));
        }
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if(x =='x' || x == '@' || x == '+'){
                characters.add(x);
            }
        }
        long result = getResult();
        System.out.println(result);

    }

    public static long getResult(){
        while(characters.size()>0){
            while(characters.contains('@')){
                int indexChar = characters.indexOf('@');
                int num1 = integers.remove(indexChar);
                int num2 = integers.remove(indexChar);
                System.out.println("indexChar = "+indexChar+" nums = "+num1+ " num2 = "+num2);
                integers.add(indexChar,num1|(num1+num2));
                characters.remove(indexChar);
            }
            while(characters.contains('x')){
                int indexChar = characters.indexOf('x');
                int num1 = integers.remove(indexChar);
                int num2 = integers.remove(indexChar);
                integers.add(indexChar,num1*num2);
                characters.remove(indexChar);
            }
            while(characters.contains('+')){
                int indexChar = characters.indexOf('+');
                int num1 = integers.remove(indexChar);
                int num2 = integers.remove(indexChar);
                integers.add(indexChar,(num1+num2));
                characters.remove(indexChar);
            }
        }
        if(integers.size()!=1) {
            System.out.println("error : "+integers.size());
        }
        return integers.get(0);


    }
}
