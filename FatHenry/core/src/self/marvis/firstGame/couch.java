package self.marvis.firstGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class couch {
Vector2 position;
Vector2 size;
Texture couch;
Rectangle bounds;
	
		public couch(Vector2 position, Vector2 size){
			this.position = position;
			this.size = size;
			
			bounds = new Rectangle(position.x, position.y, size.x, size.y);
			couch = new Texture(Gdx.files.internal("bench.png"));
		}
		
		public void update(){
			bounds.set(position.x, position.y, size.x, size.y);
		}
		
		public void draw(SpriteBatch batch){
			batch.draw(couch, position.x, position.y, size.x, size.y);
		}

		public Vector2 getPosition() {
			return position;
		}

		public void setPosition(Vector2 position) {
			this.position = position;
		}

		public Vector2 getSize() {
			return size;
		}

		public void setSize(Vector2 size) {
			this.size = size;
		}

		public Rectangle getBounds() {
			return bounds;
		}

		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}
}
