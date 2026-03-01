import io.asteroidsfx.asteroidentity.AsteroidProvider;
import io.asteroidsfx.common.ecs.EntitySpi;

module AsteroidEntity {
    requires Collision;
    requires Common;
    requires OutOfBounds;
    requires RenderComponent;
    requires javafx.graphics;
    requires Physics;
    exports io.asteroidsfx.asteroidentity;

    provides EntitySpi with AsteroidProvider;
}