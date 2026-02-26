import io.asteroidsfx.common.SystemSpi;
import io.asteroidsfx.outofbounds.OutOfBoundsSystemProvider;

module OutOfBounds {
    exports io.asteroidsfx.outofbounds;
    requires AngleComponent;
    requires Common;
    requires PositionComponent;
    requires VelocityComponent;

    provides SystemSpi with OutOfBoundsSystemProvider;
}