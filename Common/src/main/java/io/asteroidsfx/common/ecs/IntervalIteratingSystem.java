package io.asteroidsfx.common.ecs;

import java.util.List;

public abstract class IntervalIteratingSystem extends BaseSystem {
    public double interval;
    private double accumulator;

    @Override
    public void update(List<BaseEntity> entities, double deltaTime){
        if(!running) return;

        accumulator += deltaTime;
        if(accumulator >= interval){
            accumulator = 0;
            for (BaseEntity entity : entities){
                updateInterval(entity, deltaTime);
            }
        }
    }

    public abstract void updateInterval(BaseEntity entity, double deltaTime);
}
