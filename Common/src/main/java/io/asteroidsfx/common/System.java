package io.asteroidsfx.common;

import java.util.List;

public abstract class System {
    public abstract List<Class<? extends Component>> getSignature();
    public abstract void tick(double dt, List<Entity> entities);
}
