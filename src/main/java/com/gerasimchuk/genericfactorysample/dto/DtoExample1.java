package com.gerasimchuk.genericfactorysample.dto;

import java.util.Objects;

public class DtoExample1 {
    private String field1;
    private Integer field2;

    public DtoExample1(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DtoExample1 that = (DtoExample1) o;
        return Objects.equals(field1, that.field1) && Objects.equals(field2, that.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }

    @Override
    public String toString() {
        return "DtoExample1{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                '}';
    }
}
