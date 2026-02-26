package io.asteroidsfx.outofbounds;

import io.asteroidsfx.common.Component;
import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.System;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.velocitycomponent.VelocityComponent;

import java.util.List;

public class OutOfBoundsSystem extends System {

    int minX, maxX, minY, maxY;

    public OutOfBoundsSystem(int minX, int maxX, int minY, int maxY){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    // overloaded constructor that implies 0,0
    public OutOfBoundsSystem(int maxX, int maxY){
        this(0, maxX, 0, maxY);
    }

    @Override
    public List<Class<? extends Component>> getSignature() {
        return List.of(PositionComponent.class, OutOfBoundsComponent.class);
    }

    @Override
    public void tick(float dt, List<Entity> entities) {

        for (Entity entity : entities){

            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            OutOfBoundsComponent outOfBoundsComponent = entity.getComponent(OutOfBoundsComponent.class);

            double leftEdge = positionComponent.pos.x + outOfBoundsComponent.leftExtent; // x + negativeExtent
            double rightEdge = positionComponent.pos.x + outOfBoundsComponent.rightExtent; // x + positiveExtent
            double topEdge = positionComponent.pos.y + outOfBoundsComponent.topExtent; // y + negativeExtent
            double bottomEdge = positionComponent.pos.y + outOfBoundsComponent.bottomExtent; // y + positiveExtent

            // For WRAP and REMOVE: check if completely outside
            boolean exitLeft = rightEdge < minX;
            boolean exitRight = leftEdge > maxX;
            boolean exitTop = bottomEdge < minY;
            boolean exitBottom = topEdge > maxY;

            // For BOUNCE: check if touching or crossing the boundary
            boolean hitLeft = leftEdge <= minX;
            boolean hitRight = rightEdge >= maxX;
            boolean hitTop = topEdge <= minY;
            boolean hitBottom = bottomEdge >= maxY;

            switch (outOfBoundsComponent.boundsAction){

                case WRAP:
                    if(exitLeft) positionComponent.pos.x = maxX - outOfBoundsComponent.leftExtent;
                    if(exitRight) positionComponent.pos.x = minX - outOfBoundsComponent.rightExtent;
                    if(exitTop) positionComponent.pos.y = maxY - outOfBoundsComponent.topExtent;
                    if(exitBottom) positionComponent.pos.y = minY - outOfBoundsComponent.bottomExtent;
                    break;

                case BOUNCE:

                    // 2D movement
                    VelocityComponent velocityComponent = entity.getComponent(VelocityComponent.class);
                    if(velocityComponent != null){
                        if(hitLeft) {
                            positionComponent.pos.x = minX - outOfBoundsComponent.leftExtent;
                            velocityComponent.vel.x *= -1;
                        }
                        if(hitRight) {
                            positionComponent.pos.x = maxX - outOfBoundsComponent.rightExtent;
                            velocityComponent.vel.x *= -1;
                        }
                        if(hitTop) {
                            positionComponent.pos.y = minY - outOfBoundsComponent.topExtent;
                            velocityComponent.vel.y *= -1;
                        }
                        if(hitBottom) {
                            positionComponent.pos.y = maxY - outOfBoundsComponent.bottomExtent;
                            velocityComponent.vel.y *= -1;
                        }
                    }

                    break;

                case REMOVE:
                    entity.toBeRemoved |= (exitLeft || exitRight || exitTop || exitBottom);
                    break;

            }
        }
    }
}