package io.asteroidsfx.wraparoundsystem;

import io.asteroidsfx.common.Component;

/**
 * Marker component to indicate that an entity should use wraparound behavior.
 * Entities with this component will wrap around the screen edges.
 * The extent fields represent how far the entity's bounds extend from its position.
 */
public class WrapComponent extends Component {
    public int rightExtent;  // How far right from position (positive)
    public int leftExtent;   // How far left from position (negative)
    public int bottomExtent; // How far down from position (positive)
    public int topExtent;    // How far up from position (negative)

    /**
     * If true, wraps when the entire object leaves the screen (outside wrapping).
     * If false, wraps when the center position crosses the screen boundary (inside wrapping).
     */
    public boolean wrapOutside = true;
}

