import io.asteroidsfx.collision.CollisionSystemProvider;
import io.asteroidsfx.common.SystemSpi;

module Collision {
    exports io.asteroidsfx.collision;
    requires Common;
    requires PositionComponent;

    provides SystemSpi with CollisionSystemProvider;
}