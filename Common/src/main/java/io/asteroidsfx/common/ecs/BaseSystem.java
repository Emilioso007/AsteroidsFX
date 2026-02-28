package io.asteroidsfx.common.ecs;

import io.asteroidsfx.common.World;

import java.util.List;

public abstract class BaseSystem {
    public int priority;
    public boolean running = true;
    public BaseSystem(){
        this(0);
    }
    public BaseSystem(int priority){
        this.priority = priority;
    }

    public abstract List<Class<? extends BaseComponent>> getSignature();
    public abstract void update(List<BaseEntity> entities, double deltaTime);

    public abstract void start(World world);
}
