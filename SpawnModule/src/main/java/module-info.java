import io.asteroidsjaylib.common.ecs.BaseSystem;

module Spawn {
    requires Common;
    requires SpawnCommon;
    provides BaseSystem with io.asteroidsjaylib.spawn.SpawnSystem;
}