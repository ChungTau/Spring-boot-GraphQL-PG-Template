package com.chungtau.springboottemplate.exception;

public class EntityRuntimeException extends RuntimeException {
    public EntityRuntimeException(String message) {
        super(message);
    }

    public static <T> EntityRuntimeException notFound(Class<T> entity, Object entityId) {
        return new EntityRuntimeException(entity.getSimpleName() + " not found for id: " + entityId);
    }

    public static <T> EntityRuntimeException entityIdNotNull(Class<T> entity) {
        return new EntityRuntimeException(entity.getSimpleName() + " ID cannot be null");
    }
}