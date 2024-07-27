package com.gapjincoup.economeans.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityId {
    @Column(name = "id")
    String value;

    protected EntityId() {
    }

    protected EntityId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    protected static String tsid() {
        return TSID.Factory.getTsid().toString();
    }
}