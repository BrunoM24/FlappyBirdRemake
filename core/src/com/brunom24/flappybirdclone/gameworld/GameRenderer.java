package com.brunom24.flappybirdclone.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.brunom24.flappybirdclone.gameobjects.Bird;
import com.brunom24.flappybirdclone.helpers.AssetLoader;

/**
 * FlappyBirdClone Created by BrunoM24 on 21/11/2017.
 */

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch spriteBatch;

    private int midPointY;
    private int gameHeight;

    private Bird bird;

    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    public GameRenderer(GameWorld gameWorld, int gameHeight, int midPointY) {
        this.gameWorld = gameWorld;

        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true, 136, this.gameHeight);

        this.spriteBatch = new SpriteBatch();
        this.spriteBatch.setProjectionMatrix(this.camera.combined);

        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setProjectionMatrix(this.camera.combined);

        initGameObjects();
        initGameAssets();
    }

    public void render(float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        spriteBatch.begin();

        spriteBatch.disableBlending();
        spriteBatch.draw(this.bg, 0, midPointY + 23, 136, 43);

        spriteBatch.enableBlending();

        if(this.bird.shouldntFlap()){
            spriteBatch.draw(this.birdMid, this.bird.getX(), this.bird.getY(),
                    this.bird.getWidth() / 2.0f, this.bird.getHeight() / 2.0f,
                    this.bird.getWidth(), this.bird.getHeight(), 1, 1, this.bird.getRotation());
        }else {
            spriteBatch.draw((TextureRegion) this.birdAnimation.getKeyFrame(runTime), this.bird.getX(), this.bird.getY(),
                    this.bird.getWidth() / 2.0f, this.bird.getHeight() / 2.0f,
                    this.bird.getWidth(), this.bird.getHeight(), 1, 1, this.bird.getRotation());
        }

        spriteBatch.end();
    }

    private void initGameObjects(){
        this.bird = this.gameWorld.getBird();
    }

    private void initGameAssets(){
        this.bg = AssetLoader.bg;
        this.grass = AssetLoader.grass;
        this.birdAnimation = AssetLoader.birdAnimation;
        this.birdDown = AssetLoader.birdDown;
        this.birdMid = AssetLoader.bird;
        this.birdUp = AssetLoader.birdUp;
        this.skullUp = AssetLoader.skullUp;
        this.skullDown = AssetLoader.skullDown;
        this.bar = AssetLoader.bar;
    }
}
