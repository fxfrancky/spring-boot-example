package com.fxfrancky.program;

import java.util.Arrays;

public class CodilityProgram {

    public static void main(String[] args) {
        System.out.println(plusMinus("plusminusminusplus"));

    }

    public static String plusMinus(String S) {
        String plusString = S.replaceAll("plus","+");
        String minusString = plusString.replaceAll("minus","-");
        return minusString;

    }
}
