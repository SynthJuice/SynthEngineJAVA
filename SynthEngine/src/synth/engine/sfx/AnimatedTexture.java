package synth.engine.sfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import synth.engine.OutputManager;
import synth.engine.OutputType;

public class AnimatedTexture extends Texture {

	private BufferedImage[] imageArray;
	private int renderedImageIndex = 0, ticksPassed = 0, frames, animationSpeed;
	private boolean update = true;
	
	public AnimatedTexture(BufferedImage textureImage, int frames, int animationSpeed) {
		super(textureImage);
		this.frames = frames;
		this.animationSpeed = animationSpeed;
		if (textureImage.getWidth() % frames != 0) {
			OutputManager.println("Amount of frames doesn't match texture width. @ " + frames, OutputType.warning);
		}
	}
	
	public void tick() {
		if (update) {
			if (ticksPassed == animationSpeed) {
				ticksPassed = 0;
				if (renderedImageIndex == frames) {
					renderedImageIndex = 0;
				}
				renderedImageIndex++;
			}
			ticksPassed++;
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
		this.ticksPassed = 0;
	}

}
