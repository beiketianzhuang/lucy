package com.lcehn.lucy.handler;

public interface Handler<T, E> {

    T handle(E e);
}
