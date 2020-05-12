package com.nicolaslopez82.dsa.interviewquestions.anagramproblem;

public class App {

    public static void main(String[] args) {

        char[] str1 = {'r', 'e', 's', 't', 'f', 'u', 'l'};
        char[] str2 = {'f', 'l', 'u', 's', 't', 'e', 'r'};

        AnagramProblem anagramProblem = new AnagramProblem();
        System.out.println(anagramProblem.solve(str1, str2));
    }

}
