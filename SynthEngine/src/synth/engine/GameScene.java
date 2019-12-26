// -TODO-
// Find out whether a scene should have its own Renderer or if the game should only have one.
// If each scene has its own renderer, scene specific post process effects would be easier to implement.

package synth.engine;

import java.awt.Graphics;

import synth.engine.entity.EntityManager;

public class GameScene {
	
	private EntityManager entityManager;
	
	public GameScene() {
		this.entityManager = new EntityManager();
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		entityManager.render(g);
	}

}
