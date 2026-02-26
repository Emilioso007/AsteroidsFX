package io.asteroidsfx.collision;

import io.asteroidsfx.common.SystemSpi;
import io.asteroidsfx.common.World;

public class CollisionSystemProvider implements SystemSpi {
    @Override
    public void start(World world) {
        world.addSystem(new CollisionSystem());
    }
}
