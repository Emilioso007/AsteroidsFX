import io.asteroidsfx.common.ecs.BaseSystem;

module AsteroidPlayerCollisionResponseSystem {
    requires Asteroid;
    requires Collision;
    requires Common;
    requires Player;

    provides BaseSystem with io.asteroidsfx.asteroidplayercollisionresponsesystem.AsteroidPlayerCollisionResponseSystem;
}