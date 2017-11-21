package com.brunom24.flappybirdclone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.brunom24.flappybirdclone.screens.GameScreen;

public class FlappyBird extends Game{

    @Override
    public void create() {
        Gdx.app.log("FlappyBird", "created");
        setScreen(new GameScreen());
    }
}
