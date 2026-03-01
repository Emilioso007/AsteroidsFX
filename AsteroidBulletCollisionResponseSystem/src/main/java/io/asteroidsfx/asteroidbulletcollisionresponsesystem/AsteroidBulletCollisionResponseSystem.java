package io.asteroidsfx.asteroidbulletcollisionresponsesystem;

import io.asteroidsfx.asteroid.AsteroidEntity;
import io.asteroidsfx.asteroid.AsteroidSizeComponent;
import io.asteroidsfx.asteroid.AsteroidTag;
import io.asteroidsfx.bullet.BulletTag;
import io.asteroidsfx.collision.CollisionEvent;
import io.asteroidsfx.common.*;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.ecs.ResponseSystem;
import io.asteroidsfx.physics.component.PositionComponent;
import io.asteroidsfx.physics.component.VelocityComponent;

public class AsteroidBulletCollisionResponseSystem extends ResponseSystem {

    @Override
    public void start(World world) {
        world.getEventBus().subscribe(CollisionEvent.class, this::handleCollision);
    }

    private void handleCollision(CollisionEvent event){
        BaseEntity asteroid = event.getEntityWith(AsteroidTag.class);
        BaseEntity bullet = event.getEntityWith(BulletTag.class);

        if(asteroid != null && bullet != null) {
            asteroid.toBeRemoved = true;
            bullet.toBeRemoved = true;

            int asteroidSize = asteroid.getComponent(AsteroidSizeComponent.class).size;
            if (asteroidSize > AsteroidSizeComponent.SMALL){
                for(int i = 0; i < 2; i++){
                    AsteroidEntity newAsteroid = new AsteroidEntity(asteroid.getComponent(PositionComponent.class).pos.copy());
                    newAsteroid.getComponent(VelocityComponent.class).vel =
                            bullet.getComponent(VelocityComponent.class).vel.copy()
                                    .rotate(Math.toRadians(60 + i * 240))
                                    .setMag(asteroid.getComponent(VelocityComponent.class).vel.mag());
                    newAsteroid.getComponent(AsteroidSizeComponent.class).size = asteroidSize - 1;
                    World.getInstance().queueAddEntity(newAsteroid);
                }
            }

        }
    }

}