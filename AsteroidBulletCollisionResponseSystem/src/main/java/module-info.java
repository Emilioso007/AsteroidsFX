import io.asteroidsfx.common.ecs.BaseSystem;

module AsteroidBulletCollisionResponseSystem {
    requires Common;
    requires AsteroidEntity;
    requires BulletEntity;
    requires Collision;
    requires Physics;

    provides BaseSystem with io.asteroidsfx.asteroidbulletcollisionresponsesystem.AsteroidBulletCollisionResponseSystem;
}