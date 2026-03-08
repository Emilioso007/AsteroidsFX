package io.asteroidsjaylib.rendercommon;

import io.asteroidsjaylib.common.ecs.BaseComponent;

public class RenderTag extends BaseComponent {
    private int zIndex = 0;
    private boolean absolutePosition = false;


    public RenderTag(int zIndex){
        this(zIndex, false);
    }
    public RenderTag(int zIndex, boolean absolutePosition){
        this.setzIndex(zIndex);
        this.absolutePosition = absolutePosition;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public boolean isAbsolutePosition() {
        return absolutePosition;
    }
}
