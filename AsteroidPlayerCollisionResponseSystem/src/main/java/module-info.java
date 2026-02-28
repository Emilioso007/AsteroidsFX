import io.asteroidsfx.common.ecs.BaseSystem;

module AsteroidPlayerCollisionResponseSystem {
    requires AsteroidEntity;
    requires Collision;
    requires Common;
    requires PlayerEntity;

    provides BaseSystem with io.asteroidsfx.asteroidplayercollisionresponsesystem.AsteroidPlayerCollisionResponseSystem;
}