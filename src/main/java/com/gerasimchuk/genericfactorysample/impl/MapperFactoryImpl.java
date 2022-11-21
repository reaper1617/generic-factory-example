package com.gerasimchuk.genericfactorysample.impl;

import com.gerasimchuk.genericfactorysample.api.Mapper;
import com.gerasimchuk.genericfactorysample.api.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MapperFactoryImpl implements MapperFactory {

    private final List<Mapper<?, ?>> mappers;

    private Map<CompositeKey<?, ?>, Mapper<?, ?>> mappersMap;

    @Autowired
    public MapperFactoryImpl(List<Mapper<?, ?>> mappers) {
        this.mappers = mappers;
    }

    @PostConstruct
    private void postConstruct() {
        mappersMap = mappers.stream().collect(Collectors.toMap(
                m -> new CompositeKey<>(m.applicableEntityFor(), m.applicableDtoFor()),
                Function.identity()
        ));
    }

    @Override
    public <E, D> Mapper<E, D> get(Class<? extends E> eClass, Class<? extends D> dClass) {
        var mapper = mappersMap.get(new CompositeKey<>(eClass, dClass));
        if (mapper == null){
            throw new IllegalArgumentException("Mapper not found for entity class " + eClass + " and dto class " + dClass);
        }
        return (Mapper<E, D>) mapper;
    }


    static record CompositeKey<E, D>(Class<? extends E> entityClass, Class<? extends D> dtoClass) {
    }
}
