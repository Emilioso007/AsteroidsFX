package io.asteroidsfx.common;

public class Vector {
    public float x;
    public float y;

    public Vector(){
        this(0, 0);
    }
    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public static Vector fromAngle(float angleInRadians){
        return new Vector((float) Math.cos(angleInRadians), (float) Math.sin(angleInRadians));
    }

    public Vector set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector copy(){
        return new Vector(this.x, this.y);
    }

    public float mag(){
        return (float) Math.sqrt( (this.x*this.x) + (this.y*this.y) );
    }
    public float magSq(){
        return (this.x*this.x) + (this.y*this.y);
    }

    public Vector add(Vector v){
        this.add(v.x, v.y);
        return this;
    }
    public Vector add(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }
    public static Vector add(Vector v1, Vector v2){
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    public Vector sub(float x, float y){
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

    public Vector mult(float n){
        this.x *= n;
        this.y *= n;
        return this;
    }

    public static Vector mult(Vector v, float n){
        v.mult(n);
        return v;
    }

    public Vector div(float n){
        this.x /= n;
        this.y /= n;
        return this;
    }

    public static Vector div(Vector v, float n){
        v.div(n);
        return v;
    }

    public float dist(Vector v){
        float dx = x - v.x;
        float dy = y - v.y;
        return (float) Math.sqrt(dx*dx + dy*dy);
    }
    public static float dist(Vector v1, Vector v2) {
        float dx = v1.x - v2.x;
        float dy = v1.y - v2.y;
        return (float) Math.sqrt(dx*dx + dy*dy);
    }

    public float dot(Vector v) {
        return x*v.x + y*v.y;
    }
    public float dot(float x, float y) {
        return this.x*x + this.y*y;
    }
    public static float dot(Vector v1, Vector v2) {
        return v1.x*v2.x + v1.y*v2.y;
    }

    public Vector normalize(){
        float m = mag();
        if (m != 0 && m != 1) {
            div(m);
        }
        return this;
    }

    public Vector limit(float max) {
        if (magSq() > max*max) {
            normalize();
            mult(max);
        }
        return this;
    }

    public Vector setMag(float len) {
        normalize();
        mult(len);
        return this;
    }

    public float heading() {
        return (float) Math.atan2(y, x);
    }

    public Vector setHeading(float angle) {
        float m = mag();
        x = (float) (m * Math.cos(angle));
        y = (float) (m * Math.sin(angle));
        return this;
    }

    public Vector rotate(float theta) {
        float temp = x;
        x = (float) (x*Math.cos(theta) - y*Math.sin(theta));
        y = (float) (temp*Math.sin(theta) + y*Math.cos(theta));
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
