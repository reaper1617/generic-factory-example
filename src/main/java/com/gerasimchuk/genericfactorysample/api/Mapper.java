package com.gerasimchuk.genericfactorysample.api;

public interface Mapper<E,D> {
    D map(E input);
    Class<E> applicableEntityFor();
    Class<D> applicableDtoFor();
}
