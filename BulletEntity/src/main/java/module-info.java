module BulletEntity {
    requires AngleComponent;
    requires Common;
    requires javafx.graphics;
    requires VelocityComponent;
    requires PositionComponent;
    requires RenderComponent;
    requires OutOfBounds;
    requires Collision;
    exports io.asteroidsfx.bulletentity;
}