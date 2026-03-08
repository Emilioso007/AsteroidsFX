import io.asteroidsjaylib.common.ecs.EntitySpi;
import io.asteroidsjaylib.common.ecs.BaseSystem;
import io.asteroidsjaylib.enemy.EnemyCollisionResponseSystem;
import io.asteroidsjaylib.enemy.EnemyEntityProvider;
import io.asteroidsjaylib.enemy.EnemySystem;

module Enemy {
    uses io.asteroidsjaylib.bulletcommon.BulletSPI;
    requires Common;
    requires OwnershipCommon;
    requires CollisionCommon;

    requires jaylib;
    requires EnemyCommon;
    requires PhysicsCommon;
    requires RenderCommon;
    requires OutOfBoundsCommon;
    requires PlayerCommon;
    requires SpawnCommon;
    requires BulletCommon;
    requires ScoreCommon;

    provides EntitySpi with EnemyEntityProvider;
    provides BaseSystem with EnemySystem, EnemyCollisionResponseSystem;
}