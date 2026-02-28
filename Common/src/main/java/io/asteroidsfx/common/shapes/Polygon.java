package io.asteroidsfx.common.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Polygon extends BaseShape {
    public double[] x;
    public double[] y;

    public Polygon(double[] x, double[] y, Color fillColor, Color strokeColor, double strokeWeight){
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWeight = strokeWeight;
    }
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setLineWidth(strokeWeight);

        graphicsContext.fillPolygon(x, y, x.length);
        graphicsContext.strokePolygon(x, y, x.length);
    }
}
