package com.brunom24.flappybirdclone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.brunom24.flappybirdclone.gameworld.GameRenderer;
import com.brunom24.flappybirdclone.gameworld.GameWorld;
import com.brunom24.flappybirdclone.helpers.InputHandler;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */

public class GameScreen implements Screen{

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private float runTime = 0;

    public GameScreen(){

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int)(gameHeight / 2);

        this.gameWorld = new GameWorld(midPointY);
        this.gameRenderer = new GameRenderer(this.gameWorld, (int)gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(this.gameWorld.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        this.runTime += delta;
        this.gameWorld.update(delta);
        this.gameRenderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {

    }
}
