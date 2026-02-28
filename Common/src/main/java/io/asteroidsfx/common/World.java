package io.asteroidsfx.common;

import io.asteroidsfx.common.ecs.BaseComponent;
import io.asteroidsfx.common.ecs.BaseEntity;
import io.asteroidsfx.common.event.EventBus;
import io.asteroidsfx.common.ecs.BaseSystem;
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

    public EventBus getEventBus(){
        return eventBus;
    }

    public void tick(double dt){
        for(BaseSystem system : systems){
            List<Class<? extends BaseComponent>> signature = system.getSignature();

            if(signature == null || signature.isEmpty()){
                system.update(new ArrayList<>(), dt);
                continue;
            }

            List<BaseEntity> filteredEntities = new ArrayList<>();

            for(BaseEntity entity : entities){
                if(matchesSignature(entity, signature)) filteredEntities.add(entity);
            }

            system.update(filteredEntities, dt);
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

    public List<BaseEntity> getEntitiesWith(Class<? extends BaseComponent> requiredComponent){
        List<BaseEntity> result = new ArrayList<>();
        for (BaseEntity entity : entities){
            if (entity.getComponent(requiredComponent) != null) result.add(entity);
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
