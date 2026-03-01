package io.asteroidsfx.physics.system;

import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.IteratingSystem;
import io.asteroidsfx.physics.component.AccelerationComponent;
import io.asteroidsfx.physics.component.DragComponent;
import io.asteroidsfx.physics.component.PositionComponent;
import io.asteroidsfx.physics.component.VelocityComponent;

import java.util.List;

public class MovementSystem extends IteratingSystem {

    @Override
    public void start(World world) {
        this.priority = 10;
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(PositionComponent.class, VelocityComponent.class);
    }

    @Override
    public void processEntity(BaseEntity entity, double deltaTime) {
        PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
        VelocityComponent velocityComponent = entity.getComponent(VelocityComponent.class);

        AccelerationComponent accelerationComponent = entity.getComponent(AccelerationComponent.class);
        if (accelerationComponent != null){
            velocityComponent.vel.add(accelerationComponent.acc.copy().mult(deltaTime));
            accelerationComponent.acc.mult(0);
        }

        DragComponent dragComponent = entity.getComponent(DragComponent.class);
        if(dragComponent != null){
            velocityComponent.vel.mult(Math.max(0.0f, 1.0f - (dragComponent.drag * deltaTime)));
        }

        positionComponent.pos.add(velocityComponent.vel.copy().mult(deltaTime));
    }
}
