package com.deepakvadgama.testing.simple;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int add(String first, String second) {
        return Integer.parseInt(first) + Integer.parseInt(second);
    }
}
