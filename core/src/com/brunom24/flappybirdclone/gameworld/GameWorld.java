package com.brunom24.flappybirdclone.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.brunom24.flappybirdclone.gameobjects.Bird;
import com.brunom24.flappybirdclone.gameobjects.ScrollHandler;
import com.brunom24.flappybirdclone.helpers.AssetLoader;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */

public class GameWorld {

    private Bird bird;
    private ScrollHandler scrollHandler;

    private Rectangle ground;

    private int score = 0;

    public GameWorld(int midPointY){
        this.bird = new Bird(20, midPointY, 17, 12);
        this.scrollHandler = new ScrollHandler(midPointY + 66);
        this.ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta) {

        if(delta > .15f){
            delta = .15f;
        }

        this.bird.update(delta);
        this.scrollHandler.update(delta);

        if(scrollHandler.collides(bird) && this.bird.isAlive()){
            scrollHandler.stop();
            this.bird.die();
            AssetLoader.dead.play();
        }

        if(Intersector.overlaps(this.bird.getBoundes(), this.ground)){
            scrollHandler.stop();
            this.bird.die();
            this.bird.decelerate();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment){
        this.score += increment;
    }
}
