package Brick;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;


/**
 *  
 * This class is the panel in the panel who run our game
 * KeyListener is responsible for detecting the arrow keys for moving the slider, ActionListener for moving the ball.
 */

public class Game extends JPanel implements KeyListener, ActionListener  {
	
	/** The play. */
	private boolean play = false;
	
	/** The score. */
	private int score = 0;
	
	/** The total bricks. */
	private int totalBricks = 21;
	
	/**
	 * The timer is setting the time of ball.
	 *
	 */
	private Timer timer;
	
	/** The delay how fast ball should move */
	private int delay = 8;
	
	/** The playerpos X  starting position for slider */
	private int playerposX = 310; 
	
	/** The ballpos X starting position for ball */
	private int ballposX = 120;
	
	/** The ballpos Y starting position for ball */
	private int ballposY = 350;
	
	/** The ball xdir. */
	private int ballXdir = -1;
	
	/** The ball ydir. */
	private int ballYdir = -2;
	
	/** The map. */
	private MapGenerator map;
	
	/**
	 * The object MapGenerator is creating bricks with 3 rows and 7 columns.
	 */
	public Game() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
	    timer.start();
	}
		
		/**
		 * paint() method is used to draw different shapes (ball, slider etc.)
		 * g.dispose the timer calls the overridden actionPerformed method 
		 * every given milliseconds. g.dispose() just releases 
		 * all graphics resources taken from the computer by the Graphics instance.
		 *
		 * @param g the g
		 */
	public void paint(Graphics g) {
	
			g.setColor(Color.black);
			g.fillRect(1,1, 692, 592);
			
			
			map.draw((Graphics2D)g);
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 3, 592);
			g.fillRect(0, 0, 692, 3);
			g.fillRect(691, 0, 3, 592);
			
			g.setColor(Color.green);
			g.fillRect(playerposX, 550, 100, 8);
			
			g.setColor(Color.yellow);
			g.fillOval(ballposX, ballposY, 20, 20);
			
			g.dispose();  
		}
	
	
	/**
	 * This method is responsible for moving ball and connect everything.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerposX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}
			
			for(int i = 0; i < map.map.length; i++) {
				for(int j = 0; j < map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX = j* map.brickWidth + 80;
						int brickY = i* map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {  
							map.setBrickValue(0, i, j);
							totalBricks--;  
							score += 5;
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width ) {
								
							}
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
			}
			
		}
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {} 

	/**
	 * This method is responsible for detect the arrow keys, if I press left or right.
	 *
	 * @param e the e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(playerposX >= 600){
				playerposX = 600;
			} else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(playerposX < 10){
				playerposX = 10;
			} else {
				moveLeft();
			}
		}
	}
	
	/**
	 * Move right.
	 */
	public void moveRight(){
		play = true;
		playerposX+=20;
	}
	
	/**
	 * Move left.
	 */
	public void moveLeft(){
		play = true;
		playerposX-=20;
	}

	
}
