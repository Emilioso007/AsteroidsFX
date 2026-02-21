package io.asteroidsfx.velocitycomponent;

import io.asteroidsfx.common.Component;

public class VelocityComponent extends Component{
    public double dx, dy;
    public static VelocityComponent fromAngleWithSpeed(double angle, double speed){
        VelocityComponent velocityComponent = new VelocityComponent();
        velocityComponent.dx = Math.cos(angle) * speed;
        velocityComponent.dy = Math.sin(angle) * speed;
        return velocityComponent;
    }
}
