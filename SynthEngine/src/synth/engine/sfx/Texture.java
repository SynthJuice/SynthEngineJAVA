package synth.engine.sfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	
	private BufferedImage textureImage;
	
	public Texture(BufferedImage textureImage) {
		this.textureImage = textureImage;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(textureImage, x, y, null);
	}

}
