/*
 * 
 */

package Brick;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * <h1>Brick Breaker</h1>
 * This program is a simple brick breaker game 
 * creating by using JFrame and JPanel for drawing different graphics 
 * to make this game work perfectly
 * <p>.
 *
 * @author Monika Djordjević
 * @since 2017-05-30
 */

public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Game game = new Game();
		/**
		 * Properties (size, title, resizable) for JFrame
		 */
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Brick Breaker");
		obj.setResizable(false);
		/** 
		 * This method is used to close the JFrame
		 */
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * This method is adding object of Game inside object of JFrame
		 */
		obj.add(game);
		obj.setVisible(true);
	}

}
