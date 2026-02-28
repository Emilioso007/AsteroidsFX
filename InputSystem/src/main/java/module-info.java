import io.asteroidsfx.common.ecs.BaseSystem;

module InputSystem {
    requires Common;
    requires InputComponent;
    requires javafx.graphics;

    provides BaseSystem with io.asteroidsfx.inputsystem.InputSystem;
}