package self.marvis.firstGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenu implements Screen{
		Stage stage;
		Label label;
		LabelStyle style;
		BitmapFont font;
		
		TextureAtlas ButtonAtlast;
		TextButtonStyle buttonStyle;
		TextButton button;
		Skin skin;
		Sound backgroundSound;
		
		private SpriteBatch batch;
		private Texture BackgroundTexture;
		private Sprite BackgroundSprite;
		
		Game game;
		
	public MainMenu(Game game){
		this.game = game;
	}
		
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		renderBackground();
		
		
		batch.end();
		stage.act();
		stage.draw();
		
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		stage = new Stage();
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		font.scale(1);
		/*style = new LabelStyle(font, Color.RED);
		label = new Label("Noob", style);
		
		stage.addActor(label);*/
		BackgroundTexture = new Texture(Gdx.files.internal("FrontPage.jpg"));
		BackgroundSprite = new Sprite(BackgroundTexture);
		BackgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		skin =  new Skin();
		ButtonAtlast = new TextureAtlas("buttons/button.pack");
		skin.addRegions(ButtonAtlast);
		
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("button");
		buttonStyle.over = skin.getDrawable("buttonPressed");
		buttonStyle.down = skin.getDrawable("buttonPressed");
		buttonStyle.font = font;
		
		button = new TextButton("Play", buttonStyle);
		
		button.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getWidth()/4);
		button.setPosition(Gdx.graphics.getWidth()/2 - button.getWidth()/2, Gdx.graphics.getHeight()/2 - button.getHeight()/2);
		
		
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
		
		button.addListener(new InputListener(){
			public boolean touchDown(InputEvent e, float x, float y, int pointer, int button){
				game.setScreen(new PlayScreen(game));
				return true;
			}
		});
		
		batch = new SpriteBatch();
		
		startMusic();
		
	}
	
	public void startMusic() {
		backgroundSound = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
		backgroundSound.play();
	}
	
	public void renderBackground() {
        BackgroundSprite.draw(batch);
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
