package com.brunom24.flappybirdclone.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector;
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

    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {
        this.velocity.add(acceleration.cpy().scl(delta));

        if (this.velocity.y > 200) {
            this.velocity.y = 200;
        }

        this.position.add(velocity.cpy().scl(delta));

        if (this.velocity.y < 0) {
            this.rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }

        if(isFalling()){
            rotation += 480 * delta;

            if(rotation >90){
                rotation = 90;
            }
        }
    }

    public void onClick() {
        this.velocity.y = -140;
    }

    public boolean isFalling() {
        return this.velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return this.velocity.y > 70;
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
}

