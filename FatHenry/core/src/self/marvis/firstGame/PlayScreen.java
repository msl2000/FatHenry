package self.marvis.firstGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class PlayScreen implements Screen{

	private SpriteBatch batch;
	InputProcessor inputProcessor;
	Texture henry;
	player player;

	Acorn acorn;
	
	private Texture BackgroundTexture;
	private Sprite BackgroundSprite;
	enemy enemy1;
	enemy enemy2;
	
	Sound backgroundSound;
	Sound ow;
	long id;
	
	ArrayList<enemy> enemies;
	Iterator<enemy> enemyIterator;
	
	Game game;
	
	Vector2 position = new Vector2(0,10);
	ShapeRenderer sr;
	
	Stage stage;
	Label label;
	LabelStyle style;
	BitmapFont font;
	
	int score = 0;
	
	
	
	
	public PlayScreen(Game game){
		this.game = game;
	}
	
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		player.update();
		acorn.update();
		
		
		batch.begin();
		
		renderBackground();
		player.draw(batch);
		
		acorn.draw(batch);
		//couch.draw(batch);
		
		enemyIterator = enemies.iterator();
		while(enemyIterator.hasNext()){
			enemy cur = enemyIterator.next();
			cur.update();
			batch.draw(cur.getChaser(), cur.getPosition().x, cur.getPosition().y, cur.size.x, cur.size.y);
		}
		if(player.getBounds().overlaps(enemy1.getBounds()) /*|| player.getBounds().overlaps(enemy2.getBounds())*/){
			
			ow.play();
			game.setScreen(new GameOver(game));
			
		}
		
		if(player.getBounds().overlaps(acorn.getBounds())){
			
			acorn.setX((float) (Math.random()*Gdx.graphics.getWidth())/2);
			acorn.setY((float) (Math.random()*Gdx.graphics.getHeight())/2);
			acorn.setPosition(new Vector2(acorn.x,acorn.y));
			acorn.bounds.setPosition(position.x, position.y);
			
			score+=1;
		}
		font.setScale(2f, 3f);
		font.draw(batch, "SCORE: " + score, Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()-50);
		
		batch.end();
		
		sr.begin(ShapeType.Line);
		sr.setColor(Color.BLUE);
		sr.rect(player.bounds.getX(), player.bounds.getY(), player.bounds.getWidth(), player.bounds.getHeight());
		
		sr.end();
		
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		
		stage = new Stage();
		
		font = new BitmapFont(/*Gdx.files.internal("font.fnt"), false*/);
		sr = new ShapeRenderer();

		
		batch = new SpriteBatch();
		BackgroundTexture = new Texture(Gdx.files.internal("background.jpg"));
		BackgroundSprite = new Sprite(BackgroundTexture);
		BackgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		enemies = new ArrayList<enemy>();
		
		
		acorn = new Acorn(/*new Vector2 (1,1)*/);
		//couch = new couch(new Vector2(50,150), new Vector2(150,50));
		
		
		player = new player(position); 
				
		//must specify the x,y position, their target and the enemy's name
		enemy1 = new enemy(new Vector2(Gdx.graphics.getWidth()-player.currentFrame.getRegionWidth(), Gdx.graphics.getHeight()-player.currentFrame.getRegionHeight()), player, "Butters");
		//enemy2 = new enemy(new Vector2(0, Gdx.graphics.getHeight() - player.currentFrame.getRegionHeight()), player, "Kenny");
		
		enemies.add(enemy1);
		//enemies.add(enemy2);
		
		ow = Gdx.audio.newSound(Gdx.files.internal("ow.mp3"));
		startMusic();
		
		
		
		
	}
	
	public void startMusic() {
		backgroundSound = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
		//backgroundSound.play();
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
		
		
	}

	
}
