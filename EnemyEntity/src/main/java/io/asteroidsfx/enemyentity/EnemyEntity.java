package io.asteroidsfx.enemyentity;

import io.asteroidsfx.anglecomponent.AngleComponent;
import io.asteroidsfx.collision.CircleColliderComponent;
import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.Polygon;
import io.asteroidsfx.common.Vector;
import io.asteroidsfx.common.World;
import io.asteroidsfx.inputcomponent.InputComponent;
import io.asteroidsfx.outofbounds.BoundsAction;
import io.asteroidsfx.outofbounds.OutOfBoundsComponent;
import io.asteroidsfx.playerentity.PlayerTag;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.rendercomponent.RenderComponent;
import io.asteroidsfx.shootcomponent.ShootComponent;
import io.asteroidsfx.velocitycomponent.VelocityComponent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class EnemyEntity extends Entity{

    public EnemyEntity(){

        this.components.add(new EnemyTag());

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.pos = new Vector(World.getInstance().width * 0.25f, World.getInstance().height * 0.5f);
        this.components.add(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.vel = new Vector(50, 0);
        this.components.add(velocityComponent);

        AngleComponent angleComponent = new AngleComponent();
        angleComponent.angle = 0;
        this.components.add(angleComponent);

        RenderComponent renderComponent = new RenderComponent();
        double[] xs = new double[8];
        double[] ys = new double[8];
        for(int i = 0; i < 8; i++){
            xs[i] = Math.cos(Math.toRadians(i*360f/8)) * 25;
            ys[i] = Math.sin(Math.toRadians(i*360f/8)) * 25;
        }
        renderComponent.polygon = new Polygon(xs, ys, Color.DARKRED, Color.RED, 4);
        this.components.add(renderComponent);

        OutOfBoundsComponent outOfBoundsComponent = new OutOfBoundsComponent();
        outOfBoundsComponent.boundsAction = BoundsAction.WRAP;
        this.components.add(outOfBoundsComponent);

        ShootComponent shootComponent = new ShootComponent();
        shootComponent.roundsPerSecond = 0.5f;
        shootComponent.velocity = 75;
        this.components.add(shootComponent);

        InputComponent inputComponent = new InputComponent();
        inputComponent.inputActionHashMap.put(KeyCode.F, (entity, dt) -> {
           PositionComponent myPosition = entity.getComponent(PositionComponent.class);
           PositionComponent targetPosition = World.getInstance().getEntitiesWith(PlayerTag.class).getFirst().getComponent(PositionComponent.class);
           entity.getComponent(AngleComponent.class).angle = (float) Math.atan2(targetPosition.pos.y-myPosition.pos.y, targetPosition.pos.x-myPosition.pos.x);
           entity.getComponent(ShootComponent.class).shootRequested = true;
        });
        this.components.add(inputComponent);

        CircleColliderComponent circleColliderComponent = new CircleColliderComponent();
        circleColliderComponent.radius = 25;
        this.components.add(circleColliderComponent);
    }

}
