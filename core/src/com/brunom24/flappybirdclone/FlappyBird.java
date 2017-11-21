package com.brunom24.flappybirdclone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.brunom24.flappybirdclone.helpers.AssetLoader;
import com.brunom24.flappybirdclone.screens.GameScreen;

public class FlappyBird extends Game{

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
