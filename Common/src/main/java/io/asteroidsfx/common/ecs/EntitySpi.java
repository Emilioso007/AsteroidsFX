package io.asteroidsfx.common.ecs;

import io.asteroidsfx.common.World;

public interface EntitySpi {
    void start(World world);
    int getPriority();
}
