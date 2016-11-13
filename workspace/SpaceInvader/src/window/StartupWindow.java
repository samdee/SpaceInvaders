package window;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StartupWindow extends JFrame{
	static JLabel label;
	static BufferedImage image;
	static File file;
	static MainPanel panel;
	static MainPanel contentpanel;
	public static StartupWindow window;
	public StartupWindow(String name){
		super(name);
		setSize(2560, 1355);
		setFocusable(true);
		setTitle("Space Invaders");
		panel = new MainPanel();
		contentpanel = new MainPanel();
	}

	public void createAndShowGui(){
		panel.setSize(2559, 1354);
		contentpanel.setSize(2559,1354);
		panel.add(contentpanel);
		add(panel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		panel.requestFocus();
	}
}