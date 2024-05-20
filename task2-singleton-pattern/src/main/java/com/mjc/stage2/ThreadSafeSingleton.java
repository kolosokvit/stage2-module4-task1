package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance = null;
    private ThreadSafeSingleton() {

    }
    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton result = instance;
        if (result == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (result == null) {
                    instance = result = new ThreadSafeSingleton();
                }
            }
        }
        return result;
    }
}
