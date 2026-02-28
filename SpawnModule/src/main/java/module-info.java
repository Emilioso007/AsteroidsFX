import io.asteroidsfx.common.ecs.BaseSystem;

module Spawn {
    requires Common;
    requires TimerComponent;
    exports io.asteroidsfx.spawn;
    provides BaseSystem with io.asteroidsfx.spawn.SpawnSystem;
}