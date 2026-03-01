import io.asteroidsfx.common.ecs.EntitySpi;
import io.asteroidsfx.common.ecs.BaseSystem;
import io.asteroidsfx.enemyentity.EnemyEntityProvider;
import io.asteroidsfx.enemyentity.EnemySystem;

module EnemyEntity {
    requires Common;
    requires javafx.graphics;
    requires RenderComponent;
    requires PlayerEntity;
    requires OutOfBounds;
    requires Collision;
    requires BulletEntity;
    requires Spawn;
    requires Physics;

    provides EntitySpi with EnemyEntityProvider;
    provides BaseSystem with EnemySystem;
}