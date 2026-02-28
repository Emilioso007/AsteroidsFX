package io.asteroidsfx.enemyentity;

import io.asteroidsfx.common.ecs.EntitySpi;
import io.asteroidsfx.common.World;

public class EnemyEntityProvider implements EntitySpi {
    @Override
    public void start(World world) {
        world.addEntity(new EnemyEntity());
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
