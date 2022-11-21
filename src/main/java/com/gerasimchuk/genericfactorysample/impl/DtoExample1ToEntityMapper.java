package com.gerasimchuk.genericfactorysample.impl;

import com.gerasimchuk.genericfactorysample.api.Mapper;
import com.gerasimchuk.genericfactorysample.dto.DtoExample1;
import com.gerasimchuk.genericfactorysample.entity.EntityExample1;
import org.springframework.stereotype.Component;

@Component
public class DtoExample1ToEntityMapper implements Mapper<EntityExample1, DtoExample1> {


    @Override
    public DtoExample1 map(EntityExample1 input) {
        return new DtoExample1(input.toString(), 999);
    }

    @Override
    public Class<EntityExample1> applicableEntityFor() {
        return EntityExample1.class;
    }

    @Override
    public Class<DtoExample1> applicableDtoFor() {
        return DtoExample1.class;
    }
}
