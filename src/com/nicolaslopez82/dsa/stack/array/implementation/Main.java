package com.nicolaslopez82.dsa.stack.array.implementation;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Nicolas");
        stack.push("Martin");
        stack.push("Lopez");

        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());

        System.out.println(stack.pop());

        System.out.println(stack.size());

        System.out.println(stack.isEmpty());
    }
}
