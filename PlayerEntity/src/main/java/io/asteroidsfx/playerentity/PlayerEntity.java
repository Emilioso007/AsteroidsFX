package io.asteroidsfx.playerentity;

import io.asteroidsfx.TimerComponent.TimerComponent;
import io.asteroidsfx.accelerationcomponent.AccelerationComponent;
import io.asteroidsfx.anglecomponent.AngleComponent;
import io.asteroidsfx.bulletentity.BulletEntity;
import io.asteroidsfx.collision.CircleColliderComponent;
import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.Polygon;
import io.asteroidsfx.common.Vector;
import io.asteroidsfx.common.World;
import io.asteroidsfx.dragcomponent.DragComponent;
import io.asteroidsfx.inputcomponent.InputComponent;
import io.asteroidsfx.outofbounds.BoundsAction;
import io.asteroidsfx.outofbounds.OutOfBoundsComponent;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.rendercomponent.RenderComponent;
import io.asteroidsfx.spawn.SpawnEvent;
import io.asteroidsfx.velocitycomponent.VelocityComponent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.time.Duration;
import java.util.HashMap;

public class PlayerEntity extends Entity {

    public PlayerEntity(Vector startPosition){

        this.addComponent(new PlayerTag());

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.pos = startPosition;
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

        DragComponent dragComponent = new DragComponent();
        dragComponent.drag = 1f;
        this.addComponent(dragComponent);


        RenderComponent renderComponent = new RenderComponent();

        double[] xs = new double[3];
        double[] ys = new double[3];

        for(int i = 0; i < 3; i++){
            xs[i] = Math.cos(Math.toRadians(i*360f/3))*40;
            ys[i] = Math.sin(Math.toRadians(i*360f/3))*40;
        }
        xs[0] = 60;

        renderComponent.polygon = new Polygon(xs, ys, Color.BLUE, Color.CYAN, 4);

        this.addComponent(renderComponent);


        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.topExtent = -60;
        outOfBoundsComponent.bottomExtent = 60;
        outOfBoundsComponent.leftExtent = -60;
        outOfBoundsComponent.rightExtent = 60;
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.addComponent(outOfBoundsComponent);

        InputComponent inputComponent = new InputComponent();
        inputComponent.inputActionHashMap = new HashMap<>();

        // When LEFT is pressed, rotate counterclockwise
        inputComponent.inputActionHashMap.put(KeyCode.LEFT, (entity, dt) -> {
            AngleComponent angle = entity.getComponent(AngleComponent.class);
            if (angle != null) {
                angle.angle -= Math.toRadians(180) * dt; // rotate left
            }
        });

        // When RIGHT is pressed, rotate clockwise
        inputComponent.inputActionHashMap.put(KeyCode.RIGHT, (entity, dt) -> {
            AngleComponent angle = entity.getComponent(AngleComponent.class);
            if (angle != null) {
                angle.angle += Math.toRadians(180) * dt; // rotate left
            }
        });

        // When UP is pressed, add forward thrust
        inputComponent.inputActionHashMap.put(KeyCode.UP, (entity, dt) -> {
            AccelerationComponent acceleration = entity.getComponent(AccelerationComponent.class);
            double angle = entity.getComponent(AngleComponent.class).angle;
            acceleration.acc.add(Vector.fromAngle(angle).setMag(2500));
        });

        TimerComponent shootTimer = new TimerComponent();
        shootTimer.duration = Duration.ofMillis(200);
        this.addComponent(shootTimer);

        // When spacebar is pressed, request shooting
        inputComponent.inputActionHashMap.put(KeyCode.SPACE, ((entity, dt) -> {
            PositionComponent position = entity.getComponent(PositionComponent.class);
            AngleComponent angle = entity.getComponent(AngleComponent.class);
            BulletEntity bullet = new BulletEntity(position.pos.copy().add(Vector.fromAngle(angle.angle).setMag(60)), Vector.fromAngle(angle.angle).setMag(600));
            SpawnEvent event = new SpawnEvent();
            event.entityToSpawn = bullet;
            event.addComponent(entity.getComponent(TimerComponent.class));
            World.getInstance().getEventBus().publish(event);
        }));

        this.addComponent(inputComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = 50;

        this.addComponent(circleColliderComponent);

    }

}