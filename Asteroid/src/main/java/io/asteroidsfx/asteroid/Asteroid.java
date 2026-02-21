package io.asteroidsfx.asteroid;

import io.asteroidsfx.common.Entity;
import io.asteroidsfx.common.Polygon;
import io.asteroidsfx.positioncomponent.PositionComponent;
import io.asteroidsfx.rendercomponent.RenderComponent;
import io.asteroidsfx.velocitycomponent.VelocityComponent;
import io.asteroidsfx.wraparoundsystem.WrapComponent;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Random;

public class Asteroid extends Entity{

    public Asteroid(){
        Random random = new Random();

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.x = 100;
        positionComponent.y = 100;

        this.components.add(positionComponent);

        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.dx = random.nextDouble(50, 200);
        velocityComponent.dy = random.nextDouble(50, 200);

        this.components.add(velocityComponent);

        RenderComponent renderComponent = new RenderComponent();

        int points = random.nextInt(4, 13);
        double[] xs = new double[points];
        double[] ys = new double[points];

        double angleBetween = Math.toRadians(360f/points);

        for(int i = 0; i < points; i++){
            xs[i] = Math.cos(i*angleBetween)*random.nextInt(25, 75);
            ys[i] = Math.sin(i*angleBetween)*random.nextInt(25, 75);
        }

        renderComponent.polygon = new Polygon(xs, ys, Color.DARKGRAY, Color.GRAY, 2);

        this.components.add(renderComponent);

        WrapComponent wrapComponent = new WrapComponent();
        wrapComponent.rightExtent = (int) Arrays.stream(renderComponent.polygon.x).max().orElse(0);
        wrapComponent.leftExtent = (int) Arrays.stream(renderComponent.polygon.x).min().orElse(0);
        wrapComponent.bottomExtent = (int) Arrays.stream(renderComponent.polygon.y).max().orElse(0);
        wrapComponent.topExtent = (int) Arrays.stream(renderComponent.polygon.y).min().orElse(0);
        wrapComponent.wrapOutside = true;

        this.components.add(wrapComponent);
    }

}