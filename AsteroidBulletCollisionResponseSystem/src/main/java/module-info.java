import io.asteroidsfx.common.ecs.BaseSystem;

module AsteroidBulletCollisionResponseSystem {
    requires Common;
    requires AsteroidEntity;
    requires BulletEntity;
    requires Collision;
    requires PositionComponent;
    requires VelocityComponent;

    provides BaseSystem with io.asteroidsfx.asteroidbulletcollisionresponsesystem.AsteroidBulletCollisionResponseSystem;
}