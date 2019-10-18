package com.contrader.contraining.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MappableList<T> extends ArrayList<T> {
    public <U> MappableList<U> map(Function<? super T, ? extends U> mapper) {
        MappableList<U> results = new MappableList<>();
        if(mapper == null)
            return results;

        for(T t : this) {
            U r = mapper.apply(t);
            if(r != null)
                results.add(r);
        }

        return results;
    }

    public static <U,T> MappableList<U> map(List<T> list, Function<T, ? extends U> mapper) {
        MappableList<U> results = new MappableList<>();
        if(mapper == null || list == null)
            return results;

        list.forEach((t) -> {
            U r = mapper.apply(t);
            if(r != null)
                results.add(r);
        });

        return results;
    }
}
