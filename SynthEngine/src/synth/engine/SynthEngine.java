package synth.engine;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class SynthEngine implements Runnable {
	
	private boolean loopRunning = false;
	private Thread thread;
	protected JFrame frame;
	protected JPanel panel;
	protected Color backgroundColor = Color.black;
	public static boolean RENDER_DEBUG = true;
	
	public SynthEngine(String gameTitle, Dimension panelSize) {
		frame = new JFrame(gameTitle);
		panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(panelSize);
		panel.setBackground(backgroundColor);
		frame.pack();
		thread = new Thread(this);
		thread.start();
		frame.setVisible(true);
	}

	@Override
	public void run() {
		while(loopRunning) {
			
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
