package com.trunghuynh.auth.converter;

import java.util.List;

public interface GeneralConverter<S, T> {
    T convert (S source);
    S revert (T target);
    List<T> convert(List<S> source);
    List<S> revert(List<T> source);
}
