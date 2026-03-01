import io.asteroidsfx.common.ecs.BaseSystem;

module AsteroidBulletCollisionResponseSystem {
    requires Common;
    requires Asteroid;
    requires Bullet;
    requires Collision;
    requires Physics;

    provides BaseSystem with io.asteroidsfx.asteroidbulletcollisionresponsesystem.AsteroidBulletCollisionResponseSystem;
}