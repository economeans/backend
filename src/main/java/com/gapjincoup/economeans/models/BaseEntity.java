package com.gapjincoup.economeans.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity<T extends EntityId> {
    @EmbeddedId
    protected T id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected BaseEntity() {
    }

    protected BaseEntity(T id) {
        this.id = id;
    }

    protected T id() {
        return id;
    }
}