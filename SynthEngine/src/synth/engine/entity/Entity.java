package synth.engine.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import synth.engine.OutputManager;
import synth.engine.OutputType;
import synth.engine.sfx.AnimatedTexture;
import synth.engine.sfx.Texture;

public abstract class Entity {
	
	public int entityID;
	public float x, y, xVelocity, yVelocity;
	public Dimension bounds;
	public Texture texture;
	
	public Entity(ArrayList<Entity> entityList) {
		entityID = entityList.size() - 1;
		OutputManager.println(getClass().getName() + "@" + entityID + " has been created", OutputType.entityCreation);
	}
	
	public Entity(ArrayList<Entity> entityList, Dimension bounds) {
		entityID = entityList.size() - 1;
		OutputManager.println(getClass().getName() + "@" + entityID + " has been created", OutputType.entityCreation);
		this.bounds = bounds;
	}
	
	public void tick() {
		x += xVelocity;
		y += yVelocity;
		
		if (texture instanceof AnimatedTexture) {
			((AnimatedTexture) texture).tick();
		}
	}
	
	public void render(Graphics g) {
		texture.render(g, (int) x, (int) y);
	}

}
