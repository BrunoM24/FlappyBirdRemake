package com.brunom24.flappybirdclone.gameobjects;

import com.badlogic.gdx.math.*;


import java.util.Random;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */
public class Pipe extends Scrollable{

    private Random r;

    private com.badlogic.gdx.math.Rectangle skullUP, skullDown, barUp, barDown;

    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;

    private float groundY;

    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
        super(x, y, width, height, scrollSpeed);
        r = new Random();

        this.skullUP = new Rectangle();
        this.skullDown = new Rectangle();
        this.barUp = new Rectangle();
        this.barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void update(float delta){
        super.update(delta);


        barUp.set(this.position.x, this.position.y, width, height);
        barDown.set(position.x, this.position.y + height + VERTICAL_GAP, width, groundY - (position.y + height + VERTICAL_GAP));

        skullUP.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y, SKULL_WIDTH, SKULL_HEIGHT);
    }

    @Override
    public void reset(float newX){
        super.reset(newX);

        height = r.nextInt(90) + 15;
    }

    public boolean collides(Bird bird){
        if(position.x < bird.getX() + bird.getWidth()){
            return (Intersector.overlaps(bird.getBoundes(), this.barUp) ||
                    Intersector.overlaps(bird.getBoundes(), this.barDown) ||
                    Intersector.overlaps(bird.getBoundes(), this.skullDown) ||
                    Intersector.overlaps(bird.getBoundes(), this.skullUP));
        }

        return false;
    }

    public Rectangle getSkullUP() {
        return skullUP;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }
}

