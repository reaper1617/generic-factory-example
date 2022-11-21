package com.gerasimchuk.genericfactorysample.api;

public interface MapperFactory {
    <E,D> Mapper<E,D> get(Class<? extends E> eClass, Class<? extends D> dClass);
}
