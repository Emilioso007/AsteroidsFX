package io.asteroidsjaylib.background;

import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.rendercommon.ImageComponent;
import io.asteroidsjaylib.rendercommon.RenderTag;

public class BackgroundEntity extends BaseEntity {

    public BackgroundEntity(){

        ImageComponent imageComponent = new ImageComponent("stars.png", BackgroundEntity.class);
        this.addRenderComponent(imageComponent, 0);

        this.addComponent(new RenderTag(0));
    }

}
