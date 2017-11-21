package com.brunom24.flappybirdclone.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.brunom24.flappybirdclone.gameobjects.Bird;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */
public class InputHandler extends InputAdapter {

    //Properties
    private Bird bird;

    public InputHandler(Bird bird) {
        this.bird = bird;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        bird.onClick();
        return super.touchDown(screenX, screenY, pointer, button);
    }
}

