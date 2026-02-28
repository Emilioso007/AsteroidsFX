package io.asteroidsfx.common.event.input;

import io.asteroidsfx.common.event.BaseEvent;
import javafx.scene.input.KeyCode;

public class KeyJustReleasedEvent extends BaseEvent {
    public KeyCode keyCode;

    public KeyJustReleasedEvent(KeyCode keyCode) {
        this.keyCode = keyCode;
    }
}
