package io.asteroidsfx.spawn;

import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.event.BaseEvent;

public class SpawnEvent extends BaseEvent {
    public BaseEntity entityToSpawn;
}
