package io.asteroidsfx.wraparoundsystem;

import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.System;
import io.asteroidsfx.positioncomponent.PositionComponent;

import java.util.HashSet;

public class WraparoundSystem extends System {

    int minX, maxX, minY, maxY;

    public WraparoundSystem(int minX, int maxX, int minY, int maxY){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    // overloaded constructor that implies 0,0
    public WraparoundSystem(int maxX, int maxY){
        this(0, maxX, 0, maxY);
    }

    @Override
    public void tick(float dt, HashSet<Entity> entities) {
        for (Entity entity : entities){
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);

            if (positionComponent == null) {
                continue;
            }

            // Skip entities with NoWrapComponent
            if (entity.getComponent(NoWrapComponent.class) != null) {
                continue;
            }

            if(positionComponent.x < minX) positionComponent.x = maxX;
            if(positionComponent.x > maxX) positionComponent.x = minX;
            if(positionComponent.y < minY) positionComponent.y = maxY;
            if(positionComponent.y > maxY) positionComponent.y = minY;
        }
    }

}