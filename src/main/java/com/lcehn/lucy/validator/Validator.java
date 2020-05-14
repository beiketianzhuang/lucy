package com.lcehn.lucy.validator;

public interface Validator<T> {

    void valid(T t) throws Exception;
}
