package io.asteroidsfx.TimerComponent;

import io.asteroidsfx.common.World;
import io.asteroidsfx.common.ecs.BaseComponent;

import java.time.Duration;
import java.time.Instant;

public class TimerComponent extends BaseComponent {
    public Instant instant = Instant.MIN;
    public Duration duration = Duration.ZERO;
    public boolean isReady(){
        if (instant.plus(duration).isBefore(Instant.now())) {
            instant = Instant.now();
            return true;
        }
        return false;
    }
}