module BulletEntity {
    requires AngleComponent;
    requires CircleColliderComponent;
    requires Common;
    requires javafx.graphics;
    requires LinearVelocityComponent;
    requires PositionComponent;
    requires RenderComponent;
    exports io.asteroidsfx.bulletentity;
}