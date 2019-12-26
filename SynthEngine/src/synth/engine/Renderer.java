// -TODO-
// Implementing scene manager
// Implementing post process effects

package synth.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Renderer extends Canvas {
	
	private static final long serialVersionUID = -4192506733040757645L;

	public Renderer(Color backgroundColor, Dimension canvasSize) {
		setBackground(backgroundColor);
		setPreferredSize(canvasSize);
	}
	
	public void update() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void render(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}