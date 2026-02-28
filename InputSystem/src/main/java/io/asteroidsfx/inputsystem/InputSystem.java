package io.asteroidsfx.inputsystem;

import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.IteratingSystem;
import io.asteroidsfx.inputcomponent.InputComponent;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class InputSystem extends IteratingSystem {

    Set<KeyCode> keysPressed;

    @Override
    public void start(World world) {
        this.keysPressed = world.keysPressed;
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(InputComponent.class);
    }


    @Override
    public void processEntity(BaseEntity entity, double deltaTime) {
        InputComponent inputComponent = entity.getComponent(InputComponent.class);

        for (KeyCode keyCode : keysPressed){
            if(inputComponent.inputActionHashMap.containsKey(keyCode)){
                inputComponent.inputActionHashMap.get(keyCode).execute(entity, deltaTime);
            }
        }
    }
}
