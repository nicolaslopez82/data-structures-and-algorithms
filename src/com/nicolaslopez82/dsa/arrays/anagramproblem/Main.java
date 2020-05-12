package com.nicolaslopez82.dsa.arrays.anagramproblem;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {

    public static void main(String[] args) {

        String word1 = "restful";
        String word2 = "fluster";

        AnagramProblem anagramProblem = new AnagramProblem();
        System.out.println(anagramProblem.checkAnagramOrNot(word1, word2));

        char[] c1 = {'r','e','s','t','f','u','l'};
        char[] c2 = {'f','l','u','s','t','e','r'};
        System.out.println(anagramProblem.isAnagram(c1, c2));
    }


}
