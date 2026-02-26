import io.asteroidsfx.common.SystemSpi;
import io.asteroidsfx.movementsystem.MovementSystemProvider;

module MovementSystem {
    requires Common;
    requires PositionComponent;
    requires VelocityComponent;
    requires AngleComponent;
    requires DragComponent;
    requires AccelerationComponent;

    provides SystemSpi with MovementSystemProvider;
}