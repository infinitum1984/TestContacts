package com.privat.contacts.base.mapper;

import java.util.LinkedList;
import java.util.List;

abstract class BaseMapper<T1, T2> implements Mapper<T1, T2> {
    @Override
    public List<T2> map(List<T1> values) {
        LinkedList<T2> newValues = new LinkedList();
        for (T1 value :
                values) {
            newValues.add(map(value));
        }
        return newValues;
    }
}
