package self.marvis.firstGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class enemy {
	Vector2 position;
	Vector2 size;
	Texture chaser;
	Rectangle bounds;
	player player;
	private float velocityX;
	private float velocityY;
	
	public enemy(Vector2 position, player player, String character){
		this.position = position;
		size = new Vector2(Gdx.graphics.getWidth()/6, Gdx.graphics.getWidth()/6);
		if(character == "Butters"){
			chaser = new Texture(Gdx.files.internal("butters.png"));
		}else if(character == "Kenny"){
			chaser = new Texture(Gdx.files.internal("kenny.png"));
		}
		bounds = new Rectangle(position.x, position.y, size.x, size.y);
		this.player = player;
		
		velocityX = 30;
		velocityY = 30;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Texture getChaser() {
		return chaser;
	}

	public void setChaser(Texture butters) {
		this.chaser = butters;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public void update(){
		bounds = new Rectangle(position.x, position.y, size.x, size.y);
		
		
		if(position.x>Gdx.graphics.getWidth()-bounds.getWidth()){
			velocityX = -(float) (Math.random()*Gdx.graphics.getWidth()/50);
		}else if(position.x < 0){
			velocityX =(float) (Math.random()*Gdx.graphics.getWidth()/50);
		}
		if(position.y>Gdx.graphics.getHeight()-bounds.getHeight()){
			velocityY = -(float) (Math.random()*Gdx.graphics.getWidth()/100);
		}else if(position.y <0){
			velocityY = (float) (Math.random()*Gdx.graphics.getWidth()/100);
		}
		position.x = position.x + velocityX;
		position.y = position.y + velocityY;
	}
	
	
	
	
}
