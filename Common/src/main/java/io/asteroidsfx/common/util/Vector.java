package io.asteroidsfx.common.util;

public class Vector {
    public double x;
    public double y;

    public Vector(){
        this(0, 0);
    }
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static Vector fromAngle(double angleInRadians){
        return new Vector(Math.cos(angleInRadians), Math.sin(angleInRadians));
    }

    public Vector set(double x, double y){
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector copy(){
        return new Vector(this.x, this.y);
    }

    public double mag(){
        return Math.sqrt( (this.x*this.x) + (this.y*this.y) );
    }
    public double magSq(){
        return (this.x*this.x) + (this.y*this.y);
    }

    public Vector add(Vector v){
        this.add(v.x, v.y);
        return this;
    }
    public Vector add(double x, double y){
        this.x += x;
        this.y += y;
        return this;
    }
    public static Vector add(Vector v1, Vector v2){
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    public Vector sub(double x, double y){
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector sub(Vector other){
        this.sub(other.x, other.y);
        return this;
    }
    public static Vector sub(Vector v1, Vector v2){
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector mult(double n){
        this.x *= n;
        this.y *= n;
        return this;
    }

    public static Vector mult(Vector v, double n){
        v.mult(n);
        return v;
    }

    public Vector div(double n){
        this.x /= n;
        this.y /= n;
        return this;
    }

    public static Vector div(Vector v, double n){
        v.div(n);
        return v;
    }

    public double dist(Vector v){
        double dx = x - v.x;
        double dy = y - v.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public static double dist(Vector v1, Vector v2) {
        double dx = v1.x - v2.x;
        double dy = v1.y - v2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double dot(Vector v) {
        return x*v.x + y*v.y;
    }
    public double dot(double x, double y) {
        return this.x*x + this.y*y;
    }
    public static double dot(Vector v1, Vector v2) {
        return v1.x*v2.x + v1.y*v2.y;
    }

    public Vector normalize(){
        double m = mag();
        if (m != 0 && m != 1) {
            div(m);
        }
        return this;
    }

    public Vector limit(double max) {
        if (magSq() > max*max) {
            normalize();
            mult(max);
        }
        return this;
    }

    public Vector setMag(double len) {
        normalize();
        mult(len);
        return this;
    }

    public double heading() {
        return Math.atan2(y, x);
    }

    public Vector setHeading(double angle) {
        double m = mag();
        x = m * Math.cos(angle);
        y = m * Math.sin(angle);
        return this;
    }

    public Vector rotate(double theta) {
        double temp = x;
        x = x*Math.cos(theta) - y*Math.sin(theta);
        y = temp*Math.sin(theta) + y*Math.cos(theta);
        return this;
    }

    @Override
    public String toString() {
        return "[ " + x + ", " + y + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector v)) {
            return false;
        }
        return x == v.x && y == v.y;
    }

}
