package io.asteroidsfx.shootcomponent;

import io.asteroidsfx.common.Component;

public class ShootComponent extends Component {

    public boolean shootRequested = false;
    public double roundsPerSecond;
    public double velocity;
    public long msLastFired = java.lang.System.currentTimeMillis();
}