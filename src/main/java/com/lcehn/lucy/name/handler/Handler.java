package com.lcehn.lucy.name.handler;

public interface Handler<T, E> {

    T handle(E e);
}
