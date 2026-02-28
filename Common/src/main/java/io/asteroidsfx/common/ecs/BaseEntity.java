package io.asteroidsfx.common.ecs;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseEntity {
    public boolean toBeRemoved = false;
    private final Set<BaseComponent> components = new HashSet<>();

    public <T extends BaseComponent> boolean addComponent(T component){
        return components.add(component);
    }

    public <T extends BaseComponent> boolean removeComponent(Class<T> componentType){
        T component = getComponent(componentType);
        return component != null && components.remove(component);
    }

    public <T extends BaseComponent> T getComponent(Class<T> componentType) {

        for (BaseComponent c : components){
            if (componentType.isAssignableFrom(c.getClass())){
                return componentType.cast(c);
            }
        }

        return null;
    }

    public Set<BaseComponent> getComponents(){
        return components;
    }

    public <T extends BaseComponent> boolean hasComponent(Class<T> componentType) {
        if(componentType == null) return false;

        for (BaseComponent c : components){
            if(componentType.isAssignableFrom(c.getClass())){
                return true;
            }
        }
        return false;
    }

}
