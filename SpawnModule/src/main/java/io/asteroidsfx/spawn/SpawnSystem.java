package io.asteroidsfx.spawn;

import io.asteroidsfx.TimerComponent.TimerComponent;
import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.ecs.BaseSystem;
import io.asteroidsfx.common.World;

import java.time.Instant;
import java.util.List;

public class SpawnSystem extends BaseSystem {

    @Override
    public void start(World world) {
        world.getEventBus().subscribe(SpawnEvent.class, this::handleSpawnEvent);
    }

    private void handleSpawnEvent(SpawnEvent event) {
        TimerComponent timerComponent = event.getComponent(TimerComponent.class);
        if (timerComponent != null) {
            if (timerComponent.instant.plus(timerComponent.duration).isBefore(Instant.now())) {
                timerComponent.instant = Instant.now();
                World.getInstance().queueAddEntity(event.entityToSpawn);
            }
        } else {
            World.getInstance().queueAddEntity(event.entityToSpawn);
        }
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of();
    }

    @Override
    public void update(List<BaseEntity> entities, double deltaTime) {

    }

}
