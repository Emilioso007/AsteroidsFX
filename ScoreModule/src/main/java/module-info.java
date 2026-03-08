import io.asteroidsjaylib.common.ecs.BaseSystem;
import io.asteroidsjaylib.common.ecs.EntitySpi;
import io.asteroidsjaylib.score.ScoreProvider;
import io.asteroidsjaylib.score.ScoreSystem;

module Score {
    requires Common;
    requires RenderCommon;
    requires jaylib;
    requires ScoreCommon;
    requires CollisionCommon;
    requires PhysicsCommon;

    provides EntitySpi with ScoreProvider;
    provides BaseSystem with ScoreSystem;
}