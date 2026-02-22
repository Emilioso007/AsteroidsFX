package io.asteroidsfx.shootsystem;

import io.asteroidsfx.anglecomponent.AngleComponent;
import io.asteroidsfx.bulletentity.BulletEntity;
import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.System;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.shootcomponent.ShootComponent;

import java.util.ArrayList;

public class ShootSystem extends System {

    @Override
    public void tick(float dt, ArrayList<Entity> entities) {

        for(int i = 0; i < entities.size(); i++){

            Entity entity = entities.get(i);

            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            AngleComponent angleComponent = entity.getComponent(AngleComponent.class);
            ShootComponent shootComponent = entity.getComponent(ShootComponent.class);

            if(positionComponent == null || angleComponent == null || shootComponent == null) continue;

            if(!shootComponent.shootRequested) continue;

            shootComponent.shootRequested = false;

            long millisSinceLastFired = java.lang.System.currentTimeMillis()-shootComponent.msLastFired;
            long millisBetweenFires = (long)(1000/shootComponent.roundsPerSecond);
            if(millisSinceLastFired >= millisBetweenFires) {
                shootComponent.msLastFired = java.lang.System.currentTimeMillis();
                BulletEntity bulletEntity = new BulletEntity(positionComponent.x, positionComponent.y, angleComponent.angle, shootComponent.velocity);
                entities.add(bulletEntity);
            }
        }

    }
}