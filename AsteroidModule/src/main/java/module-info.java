import io.asteroidsjaylib.asteroid.AsteroidCollisionResponseSystem;
import io.asteroidsjaylib.asteroid.AsteroidProvider;
import io.asteroidsjaylib.common.ecs.BaseSystem;
import io.asteroidsjaylib.common.ecs.EntitySpi;

module Asteroid {
    requires Common;
    requires AsteroidCommon;
    requires jaylib;
    requires PhysicsCommon;
    requires RenderCommon;
    requires CollisionCommon;
    requires OutOfBoundsCommon;
    requires ScoreCommon;

    provides EntitySpi with AsteroidProvider;
    provides BaseSystem with AsteroidCollisionResponseSystem;
}