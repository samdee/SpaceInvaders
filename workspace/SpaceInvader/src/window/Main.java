package window;

import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException{
		//StartupWindow window = new StartupWindow("Space Invaders");
		StartupWindow.window = new StartupWindow("Space Invaders");
		//StartupWindow.image = ImageIO.read(new File("/Users/maui/Documents/workspace/SpaceInvaders/src/window/alien.jpg"));
		javax.swing.SwingUtilities.invokeLater(new Runnable(){public void run() {StartupWindow.window.createAndShowGui();;}});
	}
}
