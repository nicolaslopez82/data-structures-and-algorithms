package com.nicolaslopez82.dsa.interviewquestions.twoeggproblem;

public class App {

    public static void main(String[] args) {
        EggDroppingProblem droppingProblem = new EggDroppingProblem();
        System.out.println("Minimum number of drops to find the critical floor: " + droppingProblem.solve());
    }

}
