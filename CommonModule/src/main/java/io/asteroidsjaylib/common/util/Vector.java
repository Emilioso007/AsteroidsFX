package io.asteroidsjaylib.common.util;

import com.raylib.Raylib.Vector2;

/// A classic 2D vector with x and y components.
public class Vector extends Vector2 {
    public static final Vector ZERO = new Vector(0, 0);

    /// A constructor that creates a Vector with values x=0, y=0.
    public Vector(){
        this(0, 0);
    }

    /// A constructor that creates a Vector.
    /// @param x the x component of the Vector.
    /// @param y the y component of the Vector.
    public Vector(float x, float y){
        x(x);
        y(y);
    }

    /// Create a unit Vector from an angle.
    /// @param angleInDegrees the angle given in degrees.
    /// @return the unit Vector facing the specified angle.
    public static Vector fromAngle(float angleInDegrees){
        return new Vector((float) Math.cos(Math.toRadians(angleInDegrees)), (float) Math.sin(Math.toRadians(angleInDegrees)));
    }

    /// Set the components of the Vector.
    /// @param x the new x-component value.
    /// @param y the new y-component value.
    /// @return the modified Vector.
    public Vector set(float x, float y){
        x(x);
        y(y);
        return this;
    }

    /// Create a copy of a Vector.
    /// Useful to prevent modifying the original vector.
    /// @return the copy of the Vector.
    public Vector copy(){
        return new Vector(x(), y());
    }

    /// Get the magnitude of the Vector.
    /// Consider using [Vector#magSq()] to prevent expensive sqrt calculation.
    /// @return the magnitude of the Vector.
    public float mag(){
        return (float) Math.sqrt( (x()*x()) + (y()*y()) );
    }

    /// Get the squared magnitude of the Vector.
    /// @return the square magnitude of the Vector.
    public float magSq(){
        return (x()*x()) + (y()*y());
    }

    /// Adds another Vector to the Vector.
    /// @param other the Vector to add.
    /// @return the Vector after the addition.
    public Vector add(Vector other){
        this.add(other.x(), other.y());
        return this;
    }

    /// Adds components to the Vector.
    /// @param x the x-component to add.
    /// @param y the y-component to add.
    /// @return the Vector after the addition.
    public Vector add(float x, float y){
        x(x()+x);
        y(y()+y);
        return this;
    }

    /// Adds two Vectors
    /// @param v1 the first Vector to add.
    /// @param v2 the second Vector to add.
    /// @return a new Vector equaling sum of the given Vectors.
    public static Vector add(Vector v1, Vector v2){
        return new Vector(v1.x() + v2.x(), v1.y() + v2.y());
    }

    /// Subtracts another Vector from the Vector.
    /// @param other the Vector to subtract.
    /// @return the Vector after the subtraction.
    public Vector sub(Vector other){
        this.sub(other.x(), other.y());
        return this;
    }

    /// Subtracts the components from the Vector.
    /// @param x the x-component to subtract.
    /// @param y the x-component to subtract.
    /// @return the Vector after the subtraction.
    public Vector sub(float x, float y){
        return add(-x, -y);
    }

    /// Subtracts two Vectors.
    /// @param v1 the minuend Vector, e.g. the one being subtracted from.
    /// @param v2 the subtrahend Vector, e.g. the one being subtracted.
    /// @return a new Vector equaling the result of the subtraction.
    public static Vector sub(Vector v1, Vector v2){
        return new Vector(v1.x() - v2.x(), v1.y() - v2.y());
    }

    /// Multiplies both components of a Vector by the multiplier value.
    /// @param n the multiplier value.
    /// @return the Vector after the multiplication.
    public Vector mult(float n){
        x(x()*n);
        y(y()*n);
        return this;
    }

    /// Multiplies both components of the Vector by the multiplier value.
    /// @param v the Vector being multiplied.
    /// @param n the multiplier value.
    /// @return the Vector after the multiplication.
    public static Vector mult(Vector v, float n){
        v.mult(n);
        return v;
    }

    /// Divides both components of a Vector by the divisor value.
    /// @param n the divisor value.
    /// @return the Vector after the division.
    public Vector div(float n){
        return mult(1/n);
    }


    /// Divides both components of the Vector by the divisor value.
    /// @param v the Vector being divided.
    /// @param n the divisor value.
    /// @return the Vector after the division.
    public static Vector div(Vector v, float n){
        return v.div(n);
    }

    /// Calculates the distance from a Vector to the Vector.
    /// @param v the other Vector.
    /// @return the distance between the Vectors.
    public float dist(Vector v){
        double dx = x() - v.x();
        double dy = y() - v.y();
        return (float) Math.sqrt(dx*dx + dy*dy);
    }

    /// Calculates the distance from a Vector to another Vector.
    /// @param v1 the first Vector.
    /// @param v2 the second Vector.
    /// @return the distance between the Vectors.
    public static float dist(Vector v1, Vector v2) {
        float dx = v1.x() - v2.x();
        float dy = v1.y() - v2.y();
        return (float) Math.sqrt(dx*dx + dy*dy);
    }

    /// Calculates the dot-product between a Vector and the Vector.
    /// @param v the other Vector.
    /// @return the dot-product.
    public float dot(Vector v) {
        return x()*v.x() + y()*v.y();
    }

    /// Calculates the dot-product between a Vector and the components.
    /// @param x the x-component.
    /// @param y the y-component.
    /// @return the dot-product.
    public float dot(float x, float y) {
        return x()*x + y()*y;
    }

    /// Calculates the dot-product between a Vector and another Vector.
    /// @param v1 the first Vector.
    /// @param v2 the second Vector.
    /// @return the dot-product.
    public static double dot(Vector v1, Vector v2) {
        return v1.x()*v2.x() + v1.y()*v2.y();
    }

    /// Normalizes the vector, meaning the magnitude is now equal to 1.
    /// @return the Vector after the normalization.
    public Vector normalize(){
        float m = mag();
        if (m != 0 && m != 1) {
            div(m);
        }
        return this;
    }

    /// Limits the magnitude of the Vector.
    /// @param max the upper-limit of the magnitude.
    /// @return the Vector after the limit is applied.
    public Vector limit(float max) {
        if (magSq() > max*max) {
            normalize();
            mult(max);
        }
        return this;
    }

    /// Sets the magnitude to a given size.
    /// @param size the new magnitude value.
    /// @return the Vector after setting the new magnitude.
    public Vector setMag(float size) {
        normalize();
        mult(size);
        return this;
    }

    /// Calculates the heading (in degrees) of a Vector.
    /// @return the heading (in degrees).
    public float heading() {
        return (float) Math.toDegrees(Math.atan2(y(), x()));
    }

    /// Sets the heading (in degrees) of a Vector.
    /// @param angle the new heading angle (in degrees).
    /// @return the Vector after the new heading is applied.
    public Vector setHeading(float angle) {
        float m = mag();
        x((float) (m * Math.cos(Math.toRadians(angle))));
        y((float) (m * Math.sin(Math.toRadians(angle))));
        return this;
    }

    /// Rotates the heading of the Vector.
    /// @param theta the angle (in degrees) to rotate the heading.
    /// @return the Vector after the rotation.
    public Vector rotate(double theta) {
        float temp = x();
        x((float) (x()*Math.cos(Math.toRadians(theta)) - y()*Math.sin(Math.toRadians(theta))));
        y((float) (temp*Math.sin(Math.toRadians(theta)) + y()*Math.cos(Math.toRadians(theta))));
        return this;
    }

    /// Stringifies the Vector.
    /// @return a string in the format \[x, y].
    @Override
    public String toString() {
        return "[ " + x() + ", " + y() + " ]";
    }

    /// Tests equality based on x and y components.
    /// @param obj the reference object with which to compare.
    /// @return true if the other Vector has equal components, otherwise false.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector v)) {
            return false;
        }
        return x() == v.x() && y() == v.y();
    }

    /// Creates a Vector with a magnitude with a random heading.
    /// @param magnitude the magnitude of the Vector.
    /// @return the random Vector with magnitude.
    public static Vector randomVector(float magnitude) {
        return (new Vector(magnitude, 0)).rotate(Math.random()*Math.PI*2);
    }

}
