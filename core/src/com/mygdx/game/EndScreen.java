package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture endImg;
	private SpriteBatch batch;
	
	public EndScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		endImg = new Texture("end01.png");
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		batch.draw(endImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
			Level.wonStat = 0;
		}
	}
}