package io.asteroidsjaylib.rendercommon;

import io.asteroidsjaylib.common.ecs.BaseComponent;

public class RenderTag extends BaseComponent {
    private int zIndex = 0;
    public RenderTag(int zIndex){
        this.setzIndex(zIndex);
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }
}
