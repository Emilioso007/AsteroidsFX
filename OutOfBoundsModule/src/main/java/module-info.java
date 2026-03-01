import io.asteroidsfx.common.ecs.BaseSystem;

module OutOfBounds {
    exports io.asteroidsfx.outofbounds;
    requires Common;
    requires Physics;

    provides BaseSystem with io.asteroidsfx.outofbounds.OutOfBoundsSystem;
}