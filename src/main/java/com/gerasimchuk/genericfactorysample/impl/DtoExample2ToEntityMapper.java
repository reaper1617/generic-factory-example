package com.gerasimchuk.genericfactorysample.impl;

import com.gerasimchuk.genericfactorysample.api.Mapper;
import com.gerasimchuk.genericfactorysample.dto.DtoExample1;
import com.gerasimchuk.genericfactorysample.dto.DtoExample2;
import com.gerasimchuk.genericfactorysample.entity.EntityExample1;
import org.springframework.stereotype.Component;

@Component
public class DtoExample2ToEntityMapper implements Mapper<EntityExample1, DtoExample2> {

    @Override
    public DtoExample2 map(EntityExample1 input) {
        return new DtoExample2(input.toString(), 334, 444L);
    }

    @Override
    public Class<EntityExample1> applicableEntityFor() {
        return EntityExample1.class;
    }

    @Override
    public Class<DtoExample2> applicableDtoFor() {
        return DtoExample2.class;
    }
}
