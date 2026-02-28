package io.asteroidsfx.common.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EventBus {

    private final Map<Class<? extends BaseEvent>, List<EventListener>> listeners = new HashMap<>();

    public <T extends BaseEvent> void subscribe(Class<T> eventType, EventListener<T> listener){

        listeners.putIfAbsent(eventType, new ArrayList<>());

        listeners.get(eventType).add(listener);

    }

    public void publish(BaseEvent event){
        Class<? extends BaseEvent> eventType = event.getClass();

        List<EventListener> registeredListeners = listeners.get(eventType);

        if (registeredListeners != null){

            for (EventListener listener : registeredListeners){

                listener.onEvent(event);

            }

        }

    }

}
