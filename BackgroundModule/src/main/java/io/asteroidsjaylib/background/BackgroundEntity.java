package io.asteroidsjaylib.background;

import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.rendercommon.ImageComponent;
import io.asteroidsjaylib.rendercommon.RenderTag;

public class BackgroundEntity extends BaseEntity {

    public BackgroundEntity(){

        RenderTag renderTag = new RenderTag(0);

        ImageComponent imageComponent = new ImageComponent("stars.png", 1600, 1600);
        renderTag.addRenderComponent(imageComponent, 0);

        this.addComponent(renderTag);
    }

}
