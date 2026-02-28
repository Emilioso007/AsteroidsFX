package io.asteroidsfx.inputcomponent;

import io.asteroidsfx.common.ecs.BaseComponent;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class InputComponent extends BaseComponent {

    public HashMap<KeyCode, InputAction> inputActionHashMap = new HashMap<>();

}
