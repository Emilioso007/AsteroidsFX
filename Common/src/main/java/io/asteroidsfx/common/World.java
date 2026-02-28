package io.asteroidsfx.common;

import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.event.EventBus;
import io.asteroidsfx.common.ecs.BaseSystem;
import io.asteroidsfx.common.event.input.KeyDownEvent;
import io.asteroidsfx.common.event.input.KeyJustPressedEvent;
import io.asteroidsfx.common.event.input.KeyJustReleasedEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class World {

    public int width;
    public int height;
    public GraphicsContext graphicsContext;
    public List<BaseEntity> entities;
    private final List<BaseEntity> entitiesToAdd;
    public Set<BaseSystem> systems;
    private final EventBus eventBus;

    public Set<KeyCode> keysPressed;

    public double deltaTime;

    private static World instance = null;

    private World(){
        entities = new ArrayList<>();
        entitiesToAdd = new ArrayList<>();
        systems = new HashSet<>();
        keysPressed = new HashSet<>();
        eventBus = new EventBus();
    }

    public static World getInstance(){
        if(instance == null) {
            instance = new World();
        }
        return instance;
    }

    public void addKeyPressed(KeyCode keyCode){
        eventBus.publish(new KeyJustPressedEvent(keyCode));
        keysPressed.add(keyCode);
    }

    public void removeKeyPressed(KeyCode keyCode){
        eventBus.publish(new KeyJustReleasedEvent(keyCode));
        keysPressed.remove(keyCode);
    }

    public EventBus getEventBus(){
        return eventBus;
    }

    public void tick(double deltaTime){
        this.deltaTime = deltaTime;

        for (KeyCode keyCode : keysPressed){
            eventBus.publish(new KeyDownEvent(keyCode));
        }

        for(BaseSystem system : systems){
            List<Class<? extends BaseComponent>> signature = system.getSignature();

            if(signature == null || signature.isEmpty()){
                system.update(new ArrayList<>(), deltaTime);
                continue;
            }

            List<BaseEntity> filteredEntities = new ArrayList<>();

            for(BaseEntity entity : entities){
                if(matchesSignature(entity, signature)) filteredEntities.add(entity);
            }

            system.update(filteredEntities, deltaTime);
        }
        entities.removeIf(entity -> entity.toBeRemoved);
        entities.addAll(entitiesToAdd);
        entitiesToAdd.clear();
    }

    public boolean addEntity(BaseEntity entity){
        return entities.add(entity);
    }

    public boolean addSystem(BaseSystem system){
        return systems.add(system);
    }


    public <T extends BaseComponent> List<BaseEntity> getEntitiesWith(Class<T>... requiredComponents){
        List<BaseEntity> result = new ArrayList<>();
        for (BaseEntity entity : entities){
            boolean hasAllComponents = true;
            for(Class<? extends BaseComponent> requiredComponent : requiredComponents){
                if (!entity.hasComponent(requiredComponent)) {
                    hasAllComponents = false;
                    break;
                }
            }
            if (hasAllComponents) result.add(entity);
        }
        return result;
    }

    private boolean matchesSignature(BaseEntity entity, List<Class<? extends BaseComponent>> signature){
        for(Class<? extends BaseComponent> requiredType : signature){
            boolean hasComponent = false;

            for (BaseComponent c : entity.getComponents()){
                if (requiredType.isAssignableFrom(c.getClass())){
                    hasComponent = true;
                    break;
                }
            }

            if(!hasComponent) return false;
        }
        return true;
    }

    public void queueAddEntity(BaseEntity entityToSpawn) {
        entitiesToAdd.add(entityToSpawn);
    }
}
