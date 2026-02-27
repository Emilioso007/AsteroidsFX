package io.asteroidsfx.playerentity;

import io.asteroidsfx.common.EntitySpi;
import io.asteroidsfx.common.Vector;
import io.asteroidsfx.common.World;

public class PlayerEntityProvider implements EntitySpi {
    @Override
    public void start(World world) {
        world.addEntity(new PlayerEntity(new Vector(world.width/2.0, world.height/2.0)));
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
