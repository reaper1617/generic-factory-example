package com.gerasimchuk.genericfactorysample.entity;

import java.util.Objects;

public class EntityExample1 {
    private String field;

    public EntityExample1(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityExample1 that = (EntityExample1) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }

    @Override
    public String toString() {
        return "EntityExample1{" +
                "field='" + field + '\'' +
                '}';
    }
}
