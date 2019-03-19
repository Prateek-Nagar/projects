package com.prateek.reap.aop;

import java.time.LocalDateTime;

public interface TimestampAware<T> {

        T getId();

        LocalDateTime getCreatedAt();

        void setCreatedAt(LocalDateTime createdAt);

        LocalDateTime getUpdatedAt();

        void setUpdatedAt(LocalDateTime updatedAt);
 }

