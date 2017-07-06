package Brick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
// TODO: Auto-generated Javadoc

/**
 * This class is responsible for Bricks.
 */
public class MapGenerator {
	
	/** The map. */
	public int map[][];
	
	/** The brick width. */
	public int brickWidth;
	
	/** The brick height. */
	public int brickHeight;
	
	/**
	 * Instantiates a new map generator.
	 *
	 * @param row the row
	 * @param col the col
	 */
	public MapGenerator(int row, int col){
		map = new int[row][col];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = 1; 
			}	
		}
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	/**
	 * This method is to draw bricks.
	 *
	 * @param g the g
	 */
	public void draw(Graphics2D g){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}  
			}	
		}
	}
	
	/**
	 * Sets the brick value.
	 *
	 * @param value the value
	 * @param row the row
	 * @param col the col
	 */
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
		
	}
}
 