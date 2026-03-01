import io.asteroidsfx.common.ecs.BaseSystem;

module Physics {
    exports io.asteroidsfx.physics.component;
    exports io.asteroidsfx.physics.system;
    requires Common;

    provides BaseSystem with io.asteroidsfx.physics.system.MovementSystem, io.asteroidsfx.physics.system.RotateSystem;
}