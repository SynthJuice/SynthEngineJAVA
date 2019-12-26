package synth.engine.tile;

import java.awt.Graphics;

import synth.engine.sfx.AnimatedTexture;
import synth.engine.sfx.Texture;

public class Tile {
	
	private Texture texture;
	
	public Tile(int ID, Texture texture) {
		this.texture = texture;
	}
	
	public void tick() {
		if (texture instanceof AnimatedTexture) {			
			((AnimatedTexture) texture).tick();
		}
	}
	
	public void render(Graphics g, int x, int y) {
		texture.render(g, x, y);
	}

}
