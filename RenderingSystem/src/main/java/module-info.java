import io.asteroidsfx.common.ecs.BaseSystem;

module RenderingSystem {
    exports io.asteroidsfx.renderingsystem;
    requires Common;
    requires RenderComponent;
    requires javafx.graphics;
    requires Physics;
    provides BaseSystem with io.asteroidsfx.renderingsystem.RenderingSystem;
}