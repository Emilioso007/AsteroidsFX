import io.asteroidsfx.common.ecs.BaseSystem;

module Collision {
    exports io.asteroidsfx.collision;
    requires Common;
    requires PositionComponent;

    provides BaseSystem with io.asteroidsfx.collision.CollisionSystem;
}