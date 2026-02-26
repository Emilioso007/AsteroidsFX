package io.asteroidsfx.common;

public interface EntitySpi {
    public void start(World world);
    public int getPriority();
}
