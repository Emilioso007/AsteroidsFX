package io.asteroidsfx.common;

import java.util.HashSet;
import java.util.Set;

public abstract class Entity {
    public boolean toBeRemoved = false;
    private final Set<Component> components = new HashSet<>();

    public <T extends Component> boolean addComponent(T component){
        return components.add(component);
    }

    public <T extends Component> boolean removeComponent(Class<T> componentType){
        T component = getComponent(componentType);
        return component != null && components.remove(component);
    }

    public <T extends Component> T getComponent(Class<T> componentType) {

        for (Component c : components){
            if (componentType.isAssignableFrom(c.getClass())){
                return componentType.cast(c);
            }
        }

        return null;
    }

    public Set<Component> getComponents(){
        return components;
    }

    public <T extends Component> boolean hasComponent(Class<T> componentType) {
        if(componentType == null) return false;

        for (Component c : components){
            if(componentType.isAssignableFrom(c.getClass())){
                return true;
            }
        }
        return false;
    }

}
