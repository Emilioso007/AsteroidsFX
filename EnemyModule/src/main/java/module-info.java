import io.asteroidsfx.common.ecs.EntitySpi;
import io.asteroidsfx.common.ecs.BaseSystem;
import io.asteroidsfx.enemy.EnemyCollisionResponseSystem;
import io.asteroidsfx.enemy.EnemyEntityProvider;
import io.asteroidsfx.enemy.EnemySystem;

module Enemy {
    requires Common;
    requires javafx.graphics;
    requires RenderComponent;
    requires Player;
    requires OutOfBounds;
    requires Collision;
    requires Bullet;
    requires Spawn;
    requires Physics;
    requires Ownership;

    provides EntitySpi with EnemyEntityProvider;
    provides BaseSystem with EnemySystem, EnemyCollisionResponseSystem;
}