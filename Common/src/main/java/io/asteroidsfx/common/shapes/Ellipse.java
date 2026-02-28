package io.asteroidsfx.common.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends BaseShape{

    public double width;
    public double height;

    public Ellipse(int width, int height, Color fillColor) {
        this(width, height, fillColor, Color.TRANSPARENT, 0);
    }
    public Ellipse(double width, double height, Color fillColor, Color strokeColor, double strokeWeight){
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWeight = strokeWeight;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setLineWidth(strokeWeight);

        double x = -width/2;
        double y = -height/2;
        graphicsContext.fillOval(x, y, width, height);
        graphicsContext.strokeOval(x, y, width, height);
    }
}
