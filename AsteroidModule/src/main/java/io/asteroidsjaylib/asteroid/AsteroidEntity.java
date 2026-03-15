package io.asteroidsjaylib.asteroid;

import io.asteroidsjaylib.asteroidcommon.AsteroidSizeComponent;
import io.asteroidsjaylib.asteroidcommon.AsteroidTag;
import io.asteroidsjaylib.collisioncommon.CircleColliderComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.outofboundscommon.BoundsAction;
import io.asteroidsjaylib.outofboundscommon.OutOfBoundsComponent;
import io.asteroidsjaylib.physicscommon.*;
import io.asteroidsjaylib.rendercommon.shapes.*;
import io.asteroidsjaylib.rendercommon.*;

import static com.raylib.Colors.*;

import java.util.Random;

public class AsteroidEntity extends BaseEntity {

    public AsteroidEntity(Vector startPosition, Vector startVelocity, int size){

        this.addComponent(new AsteroidTag());

        AsteroidSizeComponent asteroidSizeComponent = new AsteroidSizeComponent();
        asteroidSizeComponent.size = size;
        this.addComponent(asteroidSizeComponent);

        Random random = new Random();

        PositionComponent positionComponent = new PositionComponent(startPosition);
        this.addComponent(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent(startVelocity);
        this.addComponent(velocityComponent);

        AngleComponent angleComponent = new AngleComponent();
        angleComponent.angle = 0;
        this.addComponent(angleComponent);

        RotationComponent rotationComponent = new RotationComponent();
        rotationComponent.dAngle = random.nextInt(45, 135);
        this.addComponent(rotationComponent);

        int points = random.nextInt(4, 13);
        double[] xs = new double[points];
        double[] ys = new double[points];

        double angleBetween = Math.toRadians(360f/points);

        int min = 15 + size * 10;
        int max = 35 + size * 20;

        for(int i = 0; i < points; i++){
            xs[i] = Math.cos(i*angleBetween)*random.nextInt(min, max);
            ys[i] = Math.sin(i*angleBetween)*random.nextInt(min, max);
        }

        RenderTag renderTag = new RenderTag(30);

        BaseShape shape = new Polygon(xs, ys, DARKGRAY, GRAY, 2);
        ShapeComponent shapeComponent = new ShapeComponent(shape);
        renderTag.addRenderComponent(shapeComponent, 0);

        this.addComponent(renderTag);

        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.addComponent(outOfBoundsComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = (35 + size * 20);
        this.addComponent(circleColliderComponent);

    }

}