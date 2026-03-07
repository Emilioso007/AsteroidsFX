import io.asteroidsjaylib.common.ecs.BaseSystem;
import io.asteroidsjaylib.render.RenderSystem;

module Render {
    requires jaylib;
    requires Common;
    requires RenderCommon;
    requires PhysicsCommon;

    provides BaseSystem with RenderSystem;
}