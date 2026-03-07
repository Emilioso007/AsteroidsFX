package io.asteroidsjaylib.background;

import io.asteroidsjaylib.common.ecs.BaseEntity;
import io.asteroidsjaylib.rendercommon.ImageComponent;

public class BackgroundEntity extends BaseEntity {

    public BackgroundEntity(){

        ImageComponent imageComponent = new ImageComponent("stars.png", BackgroundEntity.class);
        imageComponent.setzIndex(0);
        this.addComponent(imageComponent);

    }

}
