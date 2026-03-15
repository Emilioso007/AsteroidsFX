package io.asteroidsjaylib.physics;

import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.IteratingSystem;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.AccelerationComponent;
import io.asteroidsjaylib.physicscommon.VelocityComponent;

import java.util.List;

public class AccelerationSystem extends IteratingSystem {

    @Override
    public void start(World world) {
        this.setPriority(20);
    }

    @Override
    public void processEntity(World world, BaseEntity entity, float deltaTime) {
        Vector velocity = entity.getComponent(VelocityComponent.class).orElseThrow().vel;
        Vector acceleration = entity.getComponent(AccelerationComponent.class).orElseThrow().acc;
        velocity.add(acceleration.copy().mult(deltaTime));
        acceleration.mult(0);
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(VelocityComponent.class, AccelerationComponent.class);
    }

}
