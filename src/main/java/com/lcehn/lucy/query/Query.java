package com.lcehn.lucy.query;

import java.util.Collection;

public interface Query<T, E> {

    Collection<T> query(E e);
}
