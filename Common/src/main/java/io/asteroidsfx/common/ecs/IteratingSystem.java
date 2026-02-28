package io.asteroidsfx.common.ecs;

import java.util.List;

public abstract class IteratingSystem extends BaseSystem {
    @Override
    public void update(List<BaseEntity> entities, double deltaTime){
        for(BaseEntity entity : entities){
            processEntity(entity, deltaTime);
        }
    }
    public abstract void processEntity(BaseEntity entity, double deltaTime);
}
