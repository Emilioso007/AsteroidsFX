package io.asteroidsjaylib.rendercommon;

import com.raylib.Raylib;
import io.asteroidsjaylib.common.ecs.BaseComponent;

public abstract class RenderComponent extends BaseComponent {
    private int zIndex = 0;
    public abstract void draw(Raylib.Vector2 position, float angle);

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }
}
