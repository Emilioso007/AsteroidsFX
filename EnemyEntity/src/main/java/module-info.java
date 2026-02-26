import io.asteroidsfx.common.EntitySpi;
import io.asteroidsfx.enemyentity.EnemyEntityProvider;

module EnemyEntity {
    requires AngleComponent;
    requires Common;
    requires javafx.graphics;
    requires PositionComponent;
    requires RenderComponent;
    requires VelocityComponent;
    requires ShootComponent;
    requires InputComponent;
    requires PlayerEntity;
    requires OutOfBounds;
    requires Collision;

    provides EntitySpi with EnemyEntityProvider;
}