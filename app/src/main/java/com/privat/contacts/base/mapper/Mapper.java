package com.privat.contacts.base.mapper;

import java.util.List;

public interface Mapper<T1, T2> {
    T2 map(T1 value);

    List<T2> map(List<T1> value);
}
