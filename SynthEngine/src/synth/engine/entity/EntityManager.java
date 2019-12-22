package synth.engine.entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private ArrayList<Entity> entityList;
	
	public EntityManager() {
		entityList = new ArrayList<Entity>();
	}
	
	public void tick() {
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).render(g);
		}
	}

}
