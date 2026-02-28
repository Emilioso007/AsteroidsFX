package io.asteroidsfx.common.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class BaseShape {
    public double xOffset;
    public double yOffset;
    public Color fillColor;
    public Color strokeColor;
    public double strokeWeight;
    public abstract void draw(GraphicsContext graphicsContext);
}
