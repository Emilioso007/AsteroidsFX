package io.asteroidsfx.asteroidplayercollisionresponsesystem;

import io.asteroidsfx.asteroidentity.AsteroidTag;
import io.asteroidsfx.collision.CollisionEvent;
import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.IteratingSystem;
import io.asteroidsfx.playerentity.PlayerTag;

import java.util.List;

public class AsteroidPlayerCollisionResponseSystem extends IteratingSystem {


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

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of();
    }

    @Override
    public void update(List<BaseEntity> entities, double deltaTime) {

    }

    @Override
    public void processEntity(BaseEntity entity, double deltaTime) {

    }

}