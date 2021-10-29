package com.quickSelect;

//import java.util.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        String[] orders = next.substring(1, next.length() - 1).split(",");
        FooPrint foo = new FooPrint();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
        for (int i = 0; i < orders.length; i++) {
            threads.get(Integer.parseInt(orders[i]) - 1).start();
        }
        reader.close();
    }
}

class FooPrint {
    volatile int flag = 0;

    public FooPrint() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(flag!=0) {

        }
        printFirst.run();
        flag =1;
        //待实现
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //待实现
        while(flag!=1){
        }
        printSecond.run();
        flag=2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        //待实现
        while(flag!=2){
        }
        printThird.run();
        flag=0;
    }


}
