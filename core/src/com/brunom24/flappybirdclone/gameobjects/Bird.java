package com.brunom24.flappybirdclone.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */
public class Bird {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    private Circle boundes;

    private boolean isAlive;

    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
        this.boundes = new Circle();
        this.isAlive = true;
    }

    public void update(float delta) {
        this.velocity.add(acceleration.cpy().scl(delta));

        if (this.velocity.y > 200) {
            this.velocity.y = 200;
        }

        this.position.add(velocity.cpy().scl(delta));
        this.boundes.set(this.position.x + 9, this.position.y + 6, 6.5f);

        if (this.velocity.y < 0) {
            this.rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }

        if (isFalling() || !isAlive) {
            rotation += 480 * delta;

            if (rotation > 90) {
                rotation = 90;
            }
        }
    }

    public void onClick() {
        if (isAlive) {
            this.velocity.y = -140;
        }
    }

    public void die(){
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerate(){
        acceleration.y = 0;
    }

    public boolean isFalling() {
        return this.velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return this.velocity.y > 70 || !isAlive;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

    public Circle getBoundes() {
        return boundes;
    }

    public boolean isAlive() {
        return isAlive;
    }
}

