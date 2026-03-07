import io.asteroidsjaylib.common.ecs.BaseSystem;

module OutOfBounds {
    requires Common;
    requires PhysicsCommon;
    requires OutOfBoundsCommon;

    provides BaseSystem with io.asteroidsjaylib.outofbounds.OutOfBoundsSystem;
}