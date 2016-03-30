package self.marvis.firstGame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

 
public class player implements Serializable
{
     
		private static final long serialVersionUID = 1L;
		private int movementSpeed;
        Vector2 position;
        Vector2 size;
        String textureLoc;
        Texture texture = new Texture(Gdx.files.internal("HenryFrame.png"));
        
        private static final int col = 4;
        private static final int row = 4;
        
        Animation animation;
        Texture playerTexture;
        TextureRegion[] frames;
        TextureRegion currentFrame;
        float stateTime;
        Rectangle bounds;

        private String movement;
        
 
        public player(Vector2 position)
        {
                this.position = position;
                size = new Vector2(Gdx.graphics.getHeight()/6, Gdx.graphics.getHeight()/6);
                playerTexture = new Texture(Gdx.files.internal("HenryFrame.png"));
                TextureRegion[][] tmp = TextureRegion.split(playerTexture, playerTexture.getWidth()/col, playerTexture.getHeight()/row);
                
                frames = new TextureRegion[col * row];
                movementSpeed = 10;

                
                
                int index = 0;
                for(int i =0; i<row; i++){
                	for(int j=0; j<col; j++){
                		frames[index++] = tmp[i][j];
                	}
                }   
                
                animation = new Animation(1f, frames);
                stateTime = 0f;
                currentFrame = animation.getKeyFrame(0);
                bounds = new Rectangle(position.x, position.y, size.x, size.y);
        }
 
        
        public void draw(SpriteBatch batch){
        	batch.draw(currentFrame,position.x, position.y, size.x, size.y);
        }
        
        public Animation getAnimation() {
			return animation;
		}


		public void setAnimation(Animation animation) {
			this.animation = animation;
		}


		public TextureRegion[] getFrames() {
			return frames;
		}


		public void setFrames(TextureRegion[] frames) {
			this.frames = frames;
		}


		public TextureRegion getCurrentFrame() {
			return currentFrame;
		}


		public void setCurrentFrame(TextureRegion currentFrame) {
			this.currentFrame = currentFrame;
		}


		public float getStateTime() {
			return stateTime;
		}


		public void setStateTime(float stateTime) {
			this.stateTime = stateTime;
		}


		
        
        public void update()
        {	
        	bounds.set(position.x, position.y, size.x, size.y);
        	if(stateTime<4){
        		stateTime += Gdx.graphics.getDeltaTime();
        	}else{
        		stateTime = 0;
        	}
        	
        	stateTime += Gdx.graphics.getDeltaTime();
        	if(Gdx.input.isKeyPressed(Keys.W)){
        		if(position.y<Gdx.graphics.getHeight()-currentFrame.getRegionHeight()){
    				position.y+=movementSpeed;
    				movement = "up";
    				currentFrame = animation.getKeyFrame(12 + stateTime);
    			}
    		}
    		if(Gdx.input.isKeyPressed(Keys.S)){
    			if(position.y>0){
    				position.y-=movementSpeed;
    				movement = "down";
    				currentFrame = animation.getKeyFrame(0 + stateTime);
    			}
    		}
    		if(Gdx.input.isKeyPressed(Keys.A)){
    			if(position.x>0){
    				position.x-=movementSpeed;
    				movement = "left";
    				currentFrame = animation.getKeyFrame(4 + stateTime);
    			}
    		}
    		if(Gdx.input.isKeyPressed(Keys.D)){
    			if(position.x<(Gdx.graphics.getWidth()-currentFrame.getRegionHeight())){
    				position.x+=movementSpeed;
    				movement = "right";
    				currentFrame = animation.getKeyFrame(8 + stateTime);
    			}
    		}
    		if(Gdx.input.getAccelerometerX()>0){
    			if(position.x<(Gdx.graphics.getWidth()-currentFrame.getRegionWidth())){
    				position.x+=movementSpeed;
    				movement = "right";
    				currentFrame = animation.getKeyFrame(8);
    			}
    		}
    		if(Gdx.input.getAccelerometerX()<0){
    			if(position.x>0){
    				position.x-=movementSpeed;
    				movement = "left";
    				currentFrame = animation.getKeyFrame(4);
    			}
    		}
    		if(Gdx.input.getAccelerometerY()<0){
    			if(position.y<Gdx.graphics.getHeight()-currentFrame.getRegionHeight()){
    				position.y+=movementSpeed;
    				movement = "up";
    				currentFrame = animation.getKeyFrame(12);
    			}
    		}
    		if(Gdx.input.getAccelerometerY()>0){
    			if(position.y>0){
    				position.y-=movementSpeed;
    				movement = "down";
    				currentFrame = animation.getKeyFrame(0);
    			}
    		}
        }
        
        public Texture getPlayerTexture() {
			return playerTexture;
		}


		public void setPlayerTexture(Texture playerTexture) {
			this.playerTexture = playerTexture;
		}


		public void readjust(){
        	if(movement == "up"){
        			position.y-=movementSpeed;
        	}
        	if(movement == "down"){
    			position.y+=movementSpeed;
        	}
        	if(movement == "left"){
    			position.x+=movementSpeed;
        	}
        	if(movement == "right"){
    			position.x-=movementSpeed;
        	}
        }
 
        public Rectangle getBounds() {
			return bounds;
		}


		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}


		public Vector2 getPosition()
        {
                return position;
        }
 
        public void setPosition(Vector2 position)
        {
                this.position = position;
        }
 
        public Texture getTexture()
        {
                return texture;
        }
 
        public void setTexture(Texture texture)
        {
                this.texture = texture;
        }
 
       
    
 
        
}
