package io.asteroidsjaylib.physics;

import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.IteratingSystem;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.PositionComponent;
import io.asteroidsjaylib.physicscommon.VelocityComponent;

import java.util.List;

public class VelocitySystem extends IteratingSystem {

    @Override
    public void start(World world) {
        this.setPriority(22);
    }

    @Override
    public void processEntity(World world, BaseEntity entity, float deltaTime) {
        Vector position = entity.getComponent(PositionComponent.class).orElseThrow().pos;
        Vector velocity = entity.getComponent(VelocityComponent.class).orElseThrow().vel;
        position.add(velocity.copy().mult(deltaTime));
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(PositionComponent.class, VelocityComponent.class);
    }

}
