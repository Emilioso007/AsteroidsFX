import io.asteroidsfx.common.ecs.BaseSystem;
import io.asteroidsfx.common.ecs.EntitySpi;
import io.asteroidsfx.playerentity.PlayerEntityProvider;
import io.asteroidsfx.playerentity.PlayerSystem;

module PlayerEntity {
    exports io.asteroidsfx.playerentity;
    requires Common;
    requires javafx.graphics;
    requires RenderComponent;
    requires OutOfBounds;
    requires Collision;
    requires BulletEntity;
    requires Spawn;
    requires Physics;

    provides EntitySpi with PlayerEntityProvider;
    provides BaseSystem with PlayerSystem;
}