/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author OSTEEN
 */
class CustomStack {
    private int[] stack;
    private int[] inc;
    private int top;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int x) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        
        
        int result = stack[top] + inc[top];
        
        
        if (top > 0) {
            inc[top - 1] += inc[top];
        }
        
       
        inc[top] = 0;
        top--;
        
        return result;
    }
    
    public void increment(int k, int val) {
        if (top == -1) return;
        
        
        int idx = Math.min(k - 1, top);
        inc[idx] += val;
    }
}