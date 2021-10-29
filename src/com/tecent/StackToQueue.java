package com.tecent;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public StackToQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
