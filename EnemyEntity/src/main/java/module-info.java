import io.asteroidsfx.common.EntitySpi;
import io.asteroidsfx.enemyentity.EnemyEntityProvider;

module EnemyEntity {
    requires AngleComponent;
    requires Common;
    requires javafx.graphics;
    requires PositionComponent;
    requires RenderComponent;
    requires VelocityComponent;
    requires OutOfBoundsComponent;
    requires ShootComponent;
    requires InputComponent;
    requires PlayerEntity;

    provides EntitySpi with EnemyEntityProvider;
}