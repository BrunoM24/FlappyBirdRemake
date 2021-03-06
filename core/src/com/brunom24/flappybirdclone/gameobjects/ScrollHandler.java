package com.brunom24.flappybirdclone.gameobjects;

/**
 * FlappyBirdClone Created by BrunoM24 on 22/11/2017.
 */

public class ScrollHandler {

    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    public static final int SCROLL_SPEED = -49;
    public static final int PIPE_GAP = 49;

    public ScrollHandler(float yPos){
        frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11, SCROLL_SPEED);

        pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED, yPos);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 22, 70, SCROLL_SPEED, yPos);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 22, 60, SCROLL_SPEED, yPos);
    }

    public void update(float delta){
        frontGrass.update(delta);
        backGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        if(pipe1.isScrolledLeft()){
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        }else if(pipe2.isScrolledLeft()){
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);
        }else if(pipe3.isScrolledLeft()){
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }

        if(frontGrass.isScrolledLeft()){
            frontGrass.reset(backGrass.getTailX());
        }else if(backGrass.isScrolledLeft()){
            backGrass.reset(frontGrass.getTailX());
        }
    }

    public void stop(){
        this.frontGrass.stop();
        this.backGrass.stop();
        this.pipe1.stop();
        this.pipe2.stop();
        this.pipe3.stop();
    }

    public boolean collides(Bird bird){
        return (pipe1.collides(bird) || pipe2.collides(bird) || pipe3.collides(bird));
    }

    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Pipe getPipe1() {
        return pipe1;
    }

    public Pipe getPipe2() {
        return pipe2;
    }

    public Pipe getPipe3() {
        return pipe3;
    }
}

