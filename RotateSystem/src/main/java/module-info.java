import io.asteroidsfx.common.ecs.BaseSystem;

module RotateSystem {
    requires AngleComponent;
    requires Common;
    requires RotationComponent;

    provides BaseSystem with io.asteroidsfx.rotatesystem.RotateSystem;
}