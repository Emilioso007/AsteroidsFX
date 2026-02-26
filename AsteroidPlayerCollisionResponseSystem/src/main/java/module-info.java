import io.asteroidsfx.asteroidplayercollisionresponsesystem.AsteroidPlayerCollisionResponseSystemProvider;
import io.asteroidsfx.common.SystemSpi;

module AsteroidPlayerCollisionResponseSystem {
    requires AsteroidEntity;
    requires Collision;
    requires Common;
    requires PlayerEntity;

    provides SystemSpi with AsteroidPlayerCollisionResponseSystemProvider;
}