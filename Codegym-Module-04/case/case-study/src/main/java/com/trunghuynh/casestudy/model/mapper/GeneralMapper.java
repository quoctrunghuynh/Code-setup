package com.trunghuynh.casestudy.model.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GeneralMapper<S,T> {
    T convert(S source);
    S revert (T target);
    List<T> convert(List<S> sources);
    List<S> revert(List<T> targets);
}
