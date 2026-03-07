import io.asteroidsjaylib.common.ecs.BaseSystem;
import io.asteroidsjaylib.lifetime.LifetimeSystem;

module Lifetime {
    requires Common;
    requires LifetimeCommon;

    provides BaseSystem with LifetimeSystem;
}