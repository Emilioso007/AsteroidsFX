package io.asteroidsjaylib.physicscommon;

import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.util.Vector;

public class PositionComponent extends BaseComponent {
    public Vector pos;

    public PositionComponent(Vector pos){
        this.pos = pos;
    }
}
