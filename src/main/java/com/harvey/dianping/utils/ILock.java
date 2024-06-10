package com.harvey.dianping.utils;

public interface ILock {
    boolean tryLock();
    
    void unLock();
}
