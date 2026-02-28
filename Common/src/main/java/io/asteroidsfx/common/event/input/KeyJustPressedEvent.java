package io.asteroidsfx.common.event.input;

import io.asteroidsfx.common.event.BaseEvent;
import javafx.scene.input.KeyCode;

public class KeyJustPressedEvent extends BaseEvent {
    public KeyCode keyCode;

    public KeyJustPressedEvent(KeyCode keyCode) {
        this.keyCode = keyCode;
    }
}
