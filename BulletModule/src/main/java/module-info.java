module Bullet {
    requires Common;
    requires javafx.graphics;
    requires RenderComponent;
    requires OutOfBounds;
    requires Collision;
    requires Physics;
    requires Ownership;
    exports io.asteroidsfx.bullet;
}