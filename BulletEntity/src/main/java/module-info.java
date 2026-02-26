module BulletEntity {
    requires AngleComponent;
    requires CircleColliderComponent;
    requires Common;
    requires javafx.graphics;
    requires VelocityComponent;
    requires PositionComponent;
    requires RenderComponent;
    requires OutOfBoundsComponent;
    exports io.asteroidsfx.bulletentity;
}