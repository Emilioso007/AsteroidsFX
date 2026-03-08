package io.asteroidsjaylib.bullet;

import io.asteroidsjaylib.bulletcommon.BulletTag;
import io.asteroidsjaylib.collisioncommon.CircleColliderComponent;
import io.asteroidsjaylib.lifetimecommon.LifetimeComponent;
import io.asteroidsjaylib.outofboundscommon.BoundsAction;
import io.asteroidsjaylib.outofboundscommon.OutOfBoundsComponent;
import io.asteroidsjaylib.ownershipcommon.OwnershipComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.*;
import io.asteroidsjaylib.rendercommon.RenderTag;
import io.asteroidsjaylib.rendercommon.ShapeComponent;
import io.asteroidsjaylib.rendercommon.shapes.BaseShape;
import io.asteroidsjaylib.rendercommon.shapes.Ellipse;

import static com.raylib.Colors.*;

import java.time.Duration;

public class BulletEntity extends BaseEntity{

    public BulletEntity(BaseEntity owner, Vector startPosition, Vector velocity) {

        OwnershipComponent ownershipComponent = new OwnershipComponent();
        ownershipComponent.owner = owner;
        this.addComponent(ownershipComponent);

        this.addComponent(new BulletTag());

        PositionComponent positionComponent = new PositionComponent(startPosition);
        this.addComponent(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.vel = velocity;
        this.addComponent(velocityComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = 2.5;
        this.addComponent(circleColliderComponent);

        BaseShape shape = new Ellipse(5, 5, LIGHTGRAY);
        ShapeComponent shapeComponent = new ShapeComponent(shape);
        this.addRenderComponent(shapeComponent, 0);

        this.addComponent(new RenderTag(10));

        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.addComponent(outOfBoundsComponent);

        LifetimeComponent lifetimeComponent = new LifetimeComponent(Duration.ofSeconds(2));
        this.addComponent(lifetimeComponent);

    }
}