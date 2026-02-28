package io.asteroidsfx.common.event.input;

import io.asteroidsfx.common.event.BaseEvent;
import javafx.scene.input.KeyCode;

public class KeyDownEvent extends BaseEvent {
    public KeyCode keyCode;

    public KeyDownEvent(KeyCode keyCode) {
        this.keyCode = keyCode;
    }
}
