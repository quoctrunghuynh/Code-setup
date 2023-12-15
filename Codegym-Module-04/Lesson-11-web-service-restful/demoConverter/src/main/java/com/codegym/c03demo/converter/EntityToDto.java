package com.codegym.c03demo.converter;

public interface EntityToDto<S, T> {
    public T convert(S source);
}
