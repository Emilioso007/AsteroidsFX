package io.asteroidsfx.common.event;

public interface EventListener<T extends BaseEvent> {
    void onEvent(T event);
}
