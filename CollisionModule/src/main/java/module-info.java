import io.asteroidsjaylib.common.ecs.BaseSystem;

module Collision {
    requires Common;
    requires PhysicsCommon;
    requires CollisionCommon;

    provides BaseSystem with io.asteroidsjaylib.collision.CollisionSystem;
}