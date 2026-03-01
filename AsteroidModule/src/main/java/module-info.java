import io.asteroidsfx.asteroid.AsteroidProvider;
import io.asteroidsfx.common.ecs.EntitySpi;

module Asteroid {
    requires Collision;
    requires Common;
    requires OutOfBounds;
    requires RenderComponent;
    requires javafx.graphics;
    requires Physics;
    exports io.asteroidsfx.asteroid;

    provides EntitySpi with AsteroidProvider;
}