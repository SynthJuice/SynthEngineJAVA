package synth.engine.sfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import synth.engine.OutputManager;
import synth.engine.OutputType;

public class AnimatedTexture extends Texture {

	private BufferedImage[] imageArray;
	private int renderedImageIndex = 0;
	private boolean update = true;
	
	public AnimatedTexture(BufferedImage textureImage, int frameWidth) {
		super(textureImage);
		if (textureImage.getWidth() % frameWidth != 0) {
			OutputManager.println("Invalid frameWidth @ " + frameWidth, OutputType.warning);
		}
	}
	
	public void tick() {
		if (update) {
			
		}
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(imageArray[renderedImageIndex], x, y, null);
	}
	
	public void pause(boolean pause) {
		this.update = pause;
	}
	
	public void reset() {
		this.renderedImageIndex = 0;
	}

}
