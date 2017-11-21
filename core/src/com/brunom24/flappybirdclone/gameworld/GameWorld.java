package com.brunom24.flappybirdclone.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.brunom24.flappybirdclone.gameobjects.Bird;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */

public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY){
        this.bird = new Bird(20, midPointY, 17, 12);
    }

    public void update(float delta) {
        this.bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
}
