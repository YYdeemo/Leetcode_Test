package com.quickSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathProblems {

    public static int countPrimes(int n) {
//        int count = 0;
        List<Integer> primes = new ArrayList<Integer>();
        int i = 2;
        while(i<=n){
            if (i==2){
//                count++;
                primes.add(i);
                i++;
                continue;
            }
            boolean mod = false;
            for (int pri : primes){
                if (i%pri==0){
                    mod = true;
                    break;
                }
            }
            if(!mod) primes.add(i);
            i++;
        }
        return primes.size();
    }




}
