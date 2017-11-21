package com.brunom24.flappybirdclone.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */
public abstract class Scrollable {

    Vector2 position;
    Vector2 velocity;
    int width;
    int height;
    boolean isScrolledLeft;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed){
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(scrollSpeed, 0);
        this.width = width;
        this.height = height;
        this.isScrolledLeft = false;
    }

    public void update(float delta){
        this.position.add(velocity.cpy().scl(delta));

        if(this.position.x + width < 0){
            this.isScrolledLeft = true;
        }
    }

    public void reset(float newX){
        this.position.x = newX;
        isScrolledLeft = false;
    }

    public boolean isScrolledLeft(){
        return isScrolledLeft;
    }

    public float getTailX(){
        return this.position.x + width;
    }

    public float getX(){
        return this.position.x;
    }

    public float getY(){
        return this.position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

