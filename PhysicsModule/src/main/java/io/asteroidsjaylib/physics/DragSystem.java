package io.asteroidsjaylib.physics;

import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.IteratingSystem;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.DragComponent;
import io.asteroidsjaylib.physicscommon.VelocityComponent;

import java.util.List;

public class DragSystem extends IteratingSystem {

    @Override
    public void start(World world) {
        this.setPriority(21);
    }

    @Override
    public void processEntity(World world, BaseEntity entity, float deltaTime) {
        Vector velocity = entity.getComponent(VelocityComponent.class).orElseThrow().vel;
        float drag = entity.getComponent(DragComponent.class).orElseThrow().drag;

        if (drag == 0) {
            velocity.mult(0);
        } else {
            velocity.mult((float) Math.pow(drag, deltaTime));
        }

        if(velocity.mag()<0.01){
            velocity.mult(0);
        }
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(VelocityComponent.class, DragComponent.class);
    }

}
