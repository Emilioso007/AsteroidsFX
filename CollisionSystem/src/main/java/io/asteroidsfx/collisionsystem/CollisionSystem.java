package io.asteroidsfx.collisionsystem;

import io.asteroidsfx.circlecollidercomponent.CircleColliderComponent;
import io.asteroidsfx.common.*;
import io.asteroidsfx.common.System;
import io.asteroidsfx.positioncomponent.PositionComponent;

import java.util.List;

public class CollisionSystem extends System {

    @Override
    public List<Class<? extends Component>> getSignature() {
        return List.of(PositionComponent.class, CircleColliderComponent.class);
    }

    @Override
    public void tick(float dt, List<Entity> entities) {

        for(Entity collider : entities){

            PositionComponent colliderPosition = collider.getComponent(PositionComponent.class);
            CircleColliderComponent colliderCircle = collider.getComponent(CircleColliderComponent.class);

            for(Entity target : entities){

                if(collider == target) continue;

                PositionComponent targetPosition = target.getComponent(PositionComponent.class);
                CircleColliderComponent targetCircle = target.getComponent(CircleColliderComponent.class);

                float distanceBetweenCenters = Vector.dist(colliderPosition.pos, targetPosition.pos);
                float radiusSum = colliderCircle.radius + targetCircle.radius;
                if(distanceBetweenCenters <= radiusSum){
                    World.getInstance().getEventBus().publish(new CollisionEvent(collider, target));
                }
            }
        }
    }
}