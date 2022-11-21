package com.gerasimchuk.genericfactorysample;

import com.gerasimchuk.genericfactorysample.api.MapperFactory;
import com.gerasimchuk.genericfactorysample.dto.DtoExample1;
import com.gerasimchuk.genericfactorysample.dto.DtoExample2;
import com.gerasimchuk.genericfactorysample.entity.EntityExample1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenericFactorySampleApplication {


    private static MapperFactory mapperFactory;

    public static void main(String[] args) {
        SpringApplication.run(GenericFactorySampleApplication.class, args);



        EntityExample1 entityExample1 = new EntityExample1("entity example 1");

        var mapper1 = mapperFactory.get(EntityExample1.class, DtoExample1.class);
        var mapper2 = mapperFactory.get(EntityExample1.class, DtoExample2.class);

        System.out.println("Mapper 1: " + mapper1);
        System.out.println("Mapper 2: " + mapper2);

        var result1 = mapper1.map(entityExample1);
        var result2 = mapper2.map(entityExample1);

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);

    }

    @Autowired
    public void setMapperFactory(MapperFactory mapperFactory) {
        GenericFactorySampleApplication.mapperFactory = mapperFactory;
    }
}
