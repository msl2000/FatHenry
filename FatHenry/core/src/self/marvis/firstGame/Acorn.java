package self.marvis.firstGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Acorn {
	Texture acorn;
	Vector2 position;
	Rectangle bounds;
	float x;
	float y;
	float stateTime;
	Vector2 size;
	

	
	public Acorn(){
		size = new Vector2(Gdx.graphics.getWidth()/7,Gdx.graphics.getWidth()/7);
		x = (float) (Math.random()*Gdx.graphics.getWidth());
		y = (float) (Math.random()*Gdx.graphics.getHeight());
		acorn = new Texture(Gdx.files.internal("acorn.png"));
		position = new Vector2(x, y);
		
		
	}
	
	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	public void update(){
		bounds = new Rectangle(position.x,position.y, size.x, size.y);
		if(stateTime<5){
    		stateTime += Gdx.graphics.getDeltaTime();
    	}
		else{
    		x = (float) (Math.random()*Gdx.graphics.getWidth());
    		y = (float) (Math.random()*Gdx.graphics.getHeight());
    		stateTime = 0;
    	}
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void draw(SpriteBatch batch){
		batch.draw(acorn, x, y, size.x, size.y);
	}
	
	public Texture getAcorn() {
		return acorn;
	}

	public void setAcorn(Texture acorn) {
		this.acorn = acorn;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
}
