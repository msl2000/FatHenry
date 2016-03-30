package self.marvis.firstGame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class GameOver implements Screen{
	Game game;
		
	Stage stage;
	Label label;
	Label hiScore;
	LabelStyle style;
	BitmapFont font;
	
	TextureAtlas ButtonAtlast;
	TextButtonStyle buttonStyle;
	TextButton button;
	Skin skin;
	public int score;
	
	
	public GameOver(Game game){
		this.game = game;
	}
	
	@Override
	public void show() {
		stage = new Stage();
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		style = new LabelStyle(font, Color.BLACK);
		label = new Label("GAME OVER", style);
		
		label.setPosition(Gdx.graphics.getWidth()/2 - label.getWidth()/2, Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/6);
		
		stage.addActor(label);
		
		skin =  new Skin();
		ButtonAtlast = new TextureAtlas("buttons/button.pack");
		skin.addRegions(ButtonAtlast);
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("button");
		buttonStyle.over = skin.getDrawable("buttonPressed");
		buttonStyle.down = skin.getDrawable("buttonPressed");
		buttonStyle.font = font;
		
		button = new TextButton("Play again", buttonStyle);
		
		button.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getWidth()/6);
		button.setPosition(Gdx.graphics.getWidth()/2 - button.getWidth()/2, Gdx.graphics.getHeight()/3);
		
		stage.addActor(button);
		
		Gdx.input.setInputProcessor(stage);
		
		button.addListener(new InputListener(){
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button){
				game.setScreen(new MainMenu(game));
				return true;
			}
		});
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
			
	}
	

	@Override
	public void resize(int width, int height) {
	
		
	}

	

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
