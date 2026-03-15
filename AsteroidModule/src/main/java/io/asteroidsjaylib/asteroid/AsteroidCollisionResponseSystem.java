package io.asteroidsjaylib.asteroid;

import io.asteroidsjaylib.asteroidcommon.AsteroidSizeComponent;
import io.asteroidsjaylib.asteroidcommon.AsteroidTag;
import io.asteroidsjaylib.coincommon.CoinSPI;
import io.asteroidsjaylib.coincommon.CoinTag;
import io.asteroidsjaylib.collisioncommon.CollisionEvent;
import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.ResponseSystem;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.*;
import io.asteroidsjaylib.spawncommon.SpawnEvent;

import java.util.ServiceLoader;

public class AsteroidCollisionResponseSystem extends ResponseSystem {
    @Override
    public void start(World world) {
        world.getEventBus().subscribe(CollisionEvent.class, this::handleCollision);
    }

    private void handleCollision(World world, CollisionEvent event) {
        // If no asteroid in collision, do nothing
        if(!event.hasEntityWith(AsteroidTag.class)) return;

        BaseEntity asteroid = event.getEntityWith(AsteroidTag.class);
        BaseEntity collider = event.getOther(asteroid);

        // If collider is also asteroid, do nothing
        if (collider.hasComponent(AsteroidTag.class)) return;
        if (collider.hasComponent(CoinTag.class)) return;

        // Mark asteroid to be removed
        asteroid.setToBeRemoved(true);

        // Optionally split asteroid
        int asteroidSize = asteroid.getComponent(AsteroidSizeComponent.class).map(c -> c.size).orElseThrow();
        if (asteroidSize > AsteroidSizeComponent.SMALL){
            for(int i = 0; i < 2; i++){

                Vector position = asteroid.getComponent(PositionComponent.class).map(c -> c.pos.copy()).orElseThrow();

                float magnitude = (float) (50 + 200 * Math.random());

                Vector velocity = collider.getComponent(VelocityComponent.class).map(c -> c.vel.copy()).orElseThrow();
                velocity.rotate(60 + i * 240).setMag(magnitude);

                AsteroidEntity newAsteroid = new AsteroidEntity(position, velocity, asteroidSize - 1);
                world.queueAddEntity(newAsteroid);
            }
        }

        // Publish event
        CoinSPI coinSPI = ServiceLoader.load(CoinSPI.class).findFirst().orElseThrow();
        Vector pos = asteroid.getComponent(PositionComponent.class).orElseThrow().pos.copy();
        Vector vel = Vector.randomVector(25);
        world.getEventBus().publish(world, new SpawnEvent(coinSPI.createCoin(pos, vel, asteroidSize+1)));

    }
}
