package io.asteroidsjaylib.enemy;

import io.asteroidsjaylib.collisioncommon.CircleColliderComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.enemycommon.EnemyTag;
import io.asteroidsjaylib.outofboundscommon.BoundsAction;
import io.asteroidsjaylib.outofboundscommon.OutOfBoundsComponent;
import io.asteroidsjaylib.physicscommon.*;
import io.asteroidsjaylib.rendercommon.RenderTag;
import io.asteroidsjaylib.rendercommon.ShapeComponent;
import io.asteroidsjaylib.rendercommon.shapes.BaseShape;
import io.asteroidsjaylib.rendercommon.shapes.Ellipse;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class EnemyEntity extends BaseEntity {

    public EnemyEntity(World world){

        this.addComponent(new EnemyTag());

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.pos = new Vector(world.getWidth() * 0.25f, world.getHeight() * 0.5f);
        this.addComponent(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.vel = new Vector(50, 0);
        this.addComponent(velocityComponent);

        AngleComponent angleComponent = new AngleComponent();
        angleComponent.angle = 0;
        this.addComponent(angleComponent);

        BaseShape shape = new Ellipse(60, 40, GetColor(0x8b0000ff), RED, 4);
        ShapeComponent shapeComponent = new ShapeComponent(shape);
        this.addRenderComponent(shapeComponent, 0);

        this.addComponent(new RenderTag(20));

        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.addComponent(outOfBoundsComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = 25;
        this.addComponent(circleColliderComponent);
    }

}
