package com.brunom24.flappybirdclone.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brunom24.flappybirdclone.FlappyBird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Flappy Bird";
		config.width = 480;
		config.height = 320;
		new LwjglApplication(new FlappyBird(), config);
	}
}
