package io.asteroidsfx.inputcomponent;

import io.asteroidsfx.common.ecs.BaseEntity;

@FunctionalInterface
public interface InputAction{
    void execute(BaseEntity entity, double dt);
}
