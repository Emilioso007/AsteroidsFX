package io.asteroidsfx.collision;

import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.event.BaseEvent;

public class CollisionEvent extends BaseEvent {
    public BaseEntity a;
    public BaseEntity b;

    public CollisionEvent(BaseEntity a, BaseEntity b){
        this.a = a;
        this.b = b;
    }

    public BaseEntity getEntityWith(Class<? extends BaseComponent> componentType){
        if (a.hasComponent(componentType)){
            return a;
        }
        if(b.hasComponent(componentType)){
            return b;
        }

        return null;
    }

}
