package com.nicolaslopez82.dsa.selection;

public class App {

    public static void main(String[] args) {
        int [] nArray = {3, 8, -2, 96, 101, 28, 10, -82, 37};
        QuickSelect quickSelect = new QuickSelect(nArray);
        System.out.println(quickSelect.select(3));
    }
}
