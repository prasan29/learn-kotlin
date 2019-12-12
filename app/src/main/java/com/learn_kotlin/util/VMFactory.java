package com.learn_kotlin.util;

public class VMFactory {
    private static final VMFactory sInstance = new VMFactory();

    private VMFactory() {
    }

    public static VMFactory getInstance() {
        return sInstance;
    }
}
