package io.asteroidsjaylib.render;


import com.raylib.Raylib;
import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.BulkSystem;
import io.asteroidsjaylib.physics.component.AngleComponent;
import io.asteroidsjaylib.physics.component.PositionComponent;

import java.util.List;

import static com.raylib.Raylib.*;

public class RenderSystem extends BulkSystem {

    @Override
    public void start(World world) {
        this.setPriority(100);
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(RenderComponent.class);
    }

    @Override
    public void update(World world, List<BaseEntity> entities, double deltaTime) {
        // Order entities based on their zIndex in ascending order, meaning higher values gets drawn last
        entities.sort((a, b) -> {
            RenderComponent ra = a.getComponent(RenderComponent.class);
            RenderComponent rb = b.getComponent(RenderComponent.class);
            return Integer.compare(ra.getzIndex(), rb.getzIndex());
        });

        int w = world.getWidth();
        int h = world.getHeight();

        for (BaseEntity entity : entities) {
            RenderComponent renderComponent = entity.getComponent(RenderComponent.class);

            Raylib.Vector2 position = new Raylib.Vector2();
            float angle = 0;

            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            if (positionComponent != null) position = positionComponent.pos.toRaylibVector2();

            AngleComponent angleComponent = entity.getComponent(AngleComponent.class);
            if (angleComponent != null) angle = (float) Math.toDegrees(angleComponent.angle);

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    rlPushMatrix();
                    rlTranslatef(i * w, j * h, 0);
                    renderComponent.draw(position, angle);
                    rlPopMatrix();
                }
            }
        }
    }
}
