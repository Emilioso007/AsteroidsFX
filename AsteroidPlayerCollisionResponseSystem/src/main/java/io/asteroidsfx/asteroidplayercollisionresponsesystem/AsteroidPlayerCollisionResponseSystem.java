package io.asteroidsfx.asteroidplayercollisionresponsesystem;

import io.asteroidsfx.asteroidentity.AsteroidTag;
import io.asteroidsfx.collision.CollisionEvent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.ResponseSystem;
import io.asteroidsfx.playerentity.PlayerTag;

public class AsteroidPlayerCollisionResponseSystem extends ResponseSystem {


    @Override
    public void start(World world) {
        world.getEventBus().subscribe(CollisionEvent.class, this::handleCollision);
    }

    private void handleCollision(CollisionEvent event){
        BaseEntity asteroid = event.getEntityWith(AsteroidTag.class);
        BaseEntity player = event.getEntityWith(PlayerTag.class);

        if(asteroid != null && player != null) {
            player.toBeRemoved = true;
        }
    }

}