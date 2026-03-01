package io.asteroidsfx.asteroid;

import io.asteroidsfx.common.ecs.BaseComponent;

public class AsteroidSizeComponent extends BaseComponent {
    public static final int LARGE = 3;
    public static final int MEDIUM = 2;
    public static final int SMALL = 1;
    public int size = LARGE;
}
