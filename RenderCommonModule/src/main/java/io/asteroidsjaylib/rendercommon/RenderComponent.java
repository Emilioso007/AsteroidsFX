package io.asteroidsjaylib.rendercommon;

import com.raylib.Raylib.Vector2;
import io.asteroidsjaylib.common.ecs.BaseComponent;

public abstract class RenderComponent extends BaseComponent {
    public float xoffset;
    public float yoffset;
    public abstract void draw(Vector2 position, float angle);
}
