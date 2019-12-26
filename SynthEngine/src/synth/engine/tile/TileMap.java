package synth.engine.tile;

import java.awt.Graphics;

public class TileMap {
	
	private int width, height;
	private Tile[][] tileMap;
	private float xRenderOffset = 0, yRenderOffset = 0;
	private int tileSize = 8;
	
	public TileMap(int width, int height) {
		this.width = width;
		this.height = height;
		tileMap = new Tile[width][height];
	}
	
	public void tick() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tileMap[x][y].tick();
			}
		}
	}
	
	public void render(Graphics g) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tileMap[x][y].render(g, (int) (x * tileSize + xRenderOffset), (int) (y * tileSize + yRenderOffset));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		return tileMap[x][y];
	}

}
