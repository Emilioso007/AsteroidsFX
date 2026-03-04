package io.asteroidsfx.asteroid;

import io.asteroidsfx.common.ecs.EntitySpi;
import io.asteroidsfx.common.util.Vector;
import io.asteroidsfx.common.World;

import java.util.Random;

public class AsteroidProvider implements EntitySpi {
    @Override
    public void start(World world) {
        Random random = new Random();
        Vector startPosition = new Vector(random.nextDouble(0, world.getWidth()), random.nextDouble(0, world.getHeight()));
        world.addEntity(new AsteroidEntity(startPosition, AsteroidSizeComponent.LARGE));
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
