package com.lcehn.lucy.name.validator;

public interface Validator<T> {

    void valid(T t) throws Exception;
}
