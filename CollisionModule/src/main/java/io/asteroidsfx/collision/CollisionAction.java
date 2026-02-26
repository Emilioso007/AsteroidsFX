package io.asteroidsfx.collision;

import io.asteroidsfx.common.Entity;

@FunctionalInterface
public interface CollisionAction {
    public void execute(Entity collider, Entity target);
}
