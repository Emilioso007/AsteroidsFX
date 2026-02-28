package io.asteroidsfx.enemyentity;

import io.asteroidsfx.bulletentity.BulletEntity;
import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.util.Vector;
import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.IntervalIteratingSystem;
import io.asteroidsfx.playerentity.PlayerTag;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.spawn.SpawnEvent;

import java.util.List;

public class EnemySystem extends IntervalIteratingSystem {

    @Override
    public void start(World world) {
        this.interval = 1.0;
    }

    @Override
    public void updateInterval(BaseEntity enemy, double deltaTime) {
        BaseEntity player = World.getInstance().getEntitiesWith(PlayerTag.class).getFirst();
        if(player == null) return;

        PositionComponent enemyPosition = enemy.getComponent(PositionComponent.class);
        PositionComponent playerPosition = player.getComponent(PositionComponent.class);

        Vector bulletStart = enemyPosition.pos.copy();
        Vector bulletVelocity = playerPosition.pos.copy().sub(enemyPosition.pos).setMag(600);

        BulletEntity bullet = new BulletEntity(bulletStart, bulletVelocity);
        SpawnEvent event = new SpawnEvent();
        event.entityToSpawn = bullet;
        World.getInstance().getEventBus().publish(event);
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(EnemyTag.class);
    }

}
