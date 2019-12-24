// -CREDITS-
// Gameloops:
// 		"http://www.java-gaming.org/index.php?topic=24220.0" by Eli Delventhal
// 		Gave me extra information about interpolation and more

package synth.engine;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class SynthEngine implements Runnable {

	private boolean loopRunning = false, physicsLoop = false, gamePaused = false;
	protected JFrame frame;
	protected Renderer renderer;
	public static boolean RENDER_DEBUG = true;
	public static int FPS = 0;
	public static int FRAME_COUNT = 0;

	public SynthEngine(String gameTitle, Dimension canvasSize) {
		frame = new JFrame(gameTitle);
		renderer = new Renderer(Color.black, canvasSize);
		frame.pack();
		frame.setVisible(true);
	}

	private void physicsLoop() {
		long lastLoopTime = System.nanoTime();
		final int targetFPS = 60;
		final long optimalTime = 1000000000 / targetFPS;
		double lastFPSTime = 0;

		while (loopRunning) {
			if (physicsLoop) {
				long now = System.nanoTime();
				long updateLength = now - lastLoopTime;
				lastLoopTime = now;
				double delta = updateLength / (double) optimalTime;

				lastFPSTime += updateLength;
				FPS++;

				if (lastFPSTime >= 1000000000) {
					System.out.println("(FPS: " + FPS + ")");
					lastFPSTime = 0;
					FPS = 0;
				}

				tick(delta);

				renderer.update();
				try {
					Thread.sleep((lastLoopTime - System.nanoTime() + optimalTime) / 1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void fixedLoop() {
		final double intervalFrequency = 60.0;
		final double intervalLength = 1000000000 / intervalFrequency;
		final int maxUpdateEndurance = 5;
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();

		final double targetFPS = 60;
		final double targetRenderInterval = 1000000000 / targetFPS;

		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (loopRunning) {
			double now = System.nanoTime();
			int updateCount = 0;

			if (!gamePaused) {
				while (now - lastUpdateTime > intervalLength && updateCount < maxUpdateEndrunace) {
					tick(1);
					renderer.update();
					FRAME_COUNT++;
					
					lastUpdateTime += intervalLength;
					updateCount++;
				}

				if (now - lastUpdateTime > intervalLength) {
					lastUpdateTime = now - intervalLength;
				}

				lastRenderTime = now;

				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime) {
					FPS = FRAME_COUNT;
					FRAME_COUNT = 0;
					lastSecondTime = thisSecond;
				}

				while (now - lastRenderTime < targetRenderInterval && now - lastUpdateTime < intervalLength) {
					Thread.yield();

					try {
						Thread.sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}

					now = System.nanoTime();
				}
			}
		}
	}

	@Override
	public void run() {
		Thread loop = new Thread() {
			public void run() {
				if (physicsLoop) {					
					physicsLoop();
				} else {					
					fixedLoop();				
				}
			}
		};
		loop.start();
	}

	public void tick(double delta) {
		
	}
}
