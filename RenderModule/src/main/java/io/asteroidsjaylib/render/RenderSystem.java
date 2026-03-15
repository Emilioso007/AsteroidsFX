package io.asteroidsjaylib.render;


import io.asteroidsjaylib.common.World;
import io.asteroidsjaylib.common.ecs.BaseComponent;
import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.common.ecs.BulkSystem;
import io.asteroidsjaylib.common.util.Vector;
import io.asteroidsjaylib.physicscommon.AngleComponent;
import io.asteroidsjaylib.physicscommon.PositionComponent;
import io.asteroidsjaylib.rendercommon.RenderComponent;
import io.asteroidsjaylib.rendercommon.RenderTag;

import java.util.List;

import static com.raylib.Raylib.*;

public class RenderSystem extends BulkSystem {

    @Override
    public void start(World world) {
        this.setPriority(100);
    }

    @Override
    public List<Class<? extends BaseComponent>> getSignature() {
        return List.of(RenderTag.class);
    }

    @Override
    public void update(World world, List<BaseEntity> entities, float deltaTime) {

        // Order entities based on their zIndex in ascending order, meaning higher values gets drawn last
        entities.sort((a, b) -> {
            RenderTag ra = a.getComponent(RenderTag.class).orElseThrow();
            RenderTag rb = b.getComponent(RenderTag.class).orElseThrow();
            return Integer.compare(ra.getzIndex(), rb.getzIndex());
        });

        int w = world.getWidth();
        int h = world.getHeight();

        for (BaseEntity entity : entities) {

            RenderTag renderTag = entity.getComponent(RenderTag.class).orElseThrow();
            Vector position = entity.getComponent(PositionComponent.class).map(positionComponent -> positionComponent.pos).orElse(Vector.ZERO.copy());
            float  angle    = entity.getComponent(AngleComponent.class   ).map(angleComponent -> angleComponent.angle).orElse((float) 0);

            if(renderTag.isAbsolutePosition()){
                for (RenderComponent component : renderTag.getRenderComponents()){
                    component.draw(position, angle);
                }
                continue;
            }

            for (RenderComponent component : renderTag.getRenderComponents()){

                // Apply camera offset
                rlPushMatrix();
                rlTranslatef(
                        (float)(-world.cameraLocation.x() + world.screenWidth  / 2.0),
                        (float)(-world.cameraLocation.y() + world.screenHeight / 2.0),
                        0
                );

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        rlPushMatrix();
                        rlTranslatef(i * w, j * h, 0);

                        component.draw(position, angle);

                        rlPopMatrix();
                    }
                }

                rlPopMatrix();
            }
        }
    }
}
