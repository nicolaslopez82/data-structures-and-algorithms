package com.nicolaslopez82.dsa.recursion;

public class App {

    public static void main(String[] args) {

        App app = new App();
        System.out.println(app.recursionSum(5));

    }

    public int recursionSum(int n){
        if(n == 1) return 1;
        return n + recursionSum(n-1);
    }

    /**
     * When we used recursionSum(int n) method:
     *
     * recursionSum(4)
     *      recursionSum(3)
     *          recursionSum(2)
     *              recursionSum(1)
     *                  return 1 //base case.
     *              return 2 + 1
     *          return 3 + 2 + 1
     *      return 4 + 3 + 2 + 1
     *
     * So these method calls and values are stored on the stack.
     *
     * We unfold recursive calls (pushing them on a stack) until
     * we reach the base case and then we traverse the stack and
     * retrieve all recursive calls.
     */

}

