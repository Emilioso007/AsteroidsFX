package io.asteroidsjaylib.player;

import io.asteroidsjaylib.collisioncommon.CircleColliderComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.outofboundscommon.BoundsAction;
import io.asteroidsjaylib.outofboundscommon.OutOfBoundsComponent;
import io.asteroidsjaylib.physicscommon.*;
import io.asteroidsjaylib.playercommon.PlayerTag;
import io.asteroidsjaylib.rendercommon.RenderTag;
import io.asteroidsjaylib.rendercommon.ShapeComponent;
import io.asteroidsjaylib.rendercommon.shapes.BaseShape;
import io.asteroidsjaylib.rendercommon.shapes.Polygon;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.GetColor;

public class PlayerEntity extends BaseEntity {

    public PlayerEntity(Vector startPosition){

        this.addComponent(new PlayerTag());

        PositionComponent positionComponent = new PositionComponent(startPosition);
        this.addComponent(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.vel = new Vector();
        this.addComponent(velocityComponent);

        AccelerationComponent accelerationComponent = new AccelerationComponent();
        accelerationComponent.acc = new Vector();
        this.addComponent(accelerationComponent);

        AngleComponent angleComponent = new AngleComponent();
        angleComponent.angle = 0;
        this.addComponent(angleComponent);

        RotationComponent rotationComponent = new RotationComponent();
        this.addComponent(rotationComponent);

        DragComponent dragComponent = new DragComponent();
        dragComponent.drag = 0.25;
        this.addComponent(dragComponent);


        double[] xs = new double[3];
        double[] ys = new double[3];

        for(int i = 0; i < 3; i++){
            xs[i] = Math.cos(Math.toRadians(i*360f/3))*40;
            ys[i] = Math.sin(Math.toRadians(i*360f/3))*40;
        }
        xs[0] = 60;

        BaseShape shape = new Polygon(xs, ys, BLUE, GetColor(0x00ffffff), 4);

        ShapeComponent shapeComponent = new ShapeComponent(shape);
        this.addRenderComponent(shapeComponent, 0);

        this.addComponent(new RenderTag(50));

        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.addComponent(outOfBoundsComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = 50;

        this.addComponent(circleColliderComponent);

    }

}